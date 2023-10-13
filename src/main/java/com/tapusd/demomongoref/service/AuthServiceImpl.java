package com.tapusd.demomongoref.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Payload;
import com.tapusd.demomongoref.domain.User;
import com.tapusd.demomongoref.dto.request.AuthRequest;
import com.tapusd.demomongoref.dto.request.RegistrationRequest;
import com.tapusd.demomongoref.dto.response.AuthResponse;
import com.tapusd.demomongoref.exception.AuthException;
import com.tapusd.demomongoref.exception.NotFoundException;
import com.tapusd.demomongoref.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Optional;

public class AuthServiceImpl implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);
    private static final String ISSUER = "spring-jwt";
    private static final String ROLES_KEY = "roles";
    private static final long TOKEN_VALIDITY_IN_MILLISECONDS = 60 * 60000L; // 1 hour

    private final Algorithm algorithm;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(@Value("${app.jwt.hmac.secret-key}") String hmacSecretKey,
                           UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        algorithm = Algorithm.HMAC256(hmacSecretKey);
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        Assert.notNull(authRequest, "Auth request can not be null!");
        Assert.notNull(authRequest.email(), "Username can not be null!");
        Assert.notNull(authRequest.password(), "Password can not be null!");
        User user = userRepository.findByEmail(authRequest.email())
                .orElseThrow(AuthException::new);

        if (!passwordEncoder.matches(authRequest.password(), user.getPassword())) {
            throw new AuthException();
        }

        return new AuthResponse(createJWT(user));
    }

    @Override
    public String createJWT(User user) {
        return Optional.ofNullable(user)
                .map(u -> JWT.create()
                        .withIssuer(ISSUER)
                        .withSubject(u.getId().toString())
                        .withIssuedAt(new Date())
                        .withExpiresAt(new Date(new Date().getTime() + TOKEN_VALIDITY_IN_MILLISECONDS))
                        .sign(algorithm))
                .orElseThrow(() -> new JWTCreationException("Unable to create jwt", null));

    }

    @Override
    public User verifyJWT(String jwt) {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();

        return Optional.ofNullable(jwt)
                .map(verifier::verify)
                .map(Payload::getSubject)
                .map(ObjectId::new)
                .flatMap(userRepository::findById)
                .orElseThrow(() -> new AuthException("Invalid jwt"));
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        var account = new User()
                .setName(request.name())
                .setEmail(request.email())
                .setPassword(passwordEncoder.encode(request.password()));

        return userRepository.save(account);
    }
}
