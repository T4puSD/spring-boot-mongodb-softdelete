package com.tapusd.demomongoref.repository;

import com.mongodb.client.DistinctIterable;
import com.tapusd.demomongoref.domain.User;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserRepository extends SoftDeleteRepository<User, ObjectId>{
    Optional<User> findByEmail(String email);
}
