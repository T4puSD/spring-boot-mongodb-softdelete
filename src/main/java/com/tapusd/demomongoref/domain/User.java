package com.tapusd.demomongoref.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = User.COLLECTION_NAME)
public class User extends AbstractDocument {

    public static final String COLLECTION_NAME = "user";

    @Id
    private ObjectId id;

    private String name;

    @Email(message = "Email must be valid")
    @Indexed(unique = true)
    private String email;

    @Length(min = 8, max = 32, message = "Minimum 8 character and max 32 character needed")
    @Pattern(regexp = "[0-9a-zA-Z!@#$%^&*()]+", message = "Must contain digits small, capital and special characters")
    private String password;

    public ObjectId getId() {
        return id;
    }

    public User setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
