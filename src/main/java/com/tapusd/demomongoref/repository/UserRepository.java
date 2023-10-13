package com.tapusd.demomongoref.repository;

import com.tapusd.demomongoref.domain.User;
import org.bson.types.ObjectId;

public interface UserRepository extends SoftDeleteRepository<User, ObjectId>{
}
