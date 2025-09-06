package com.apexcify.event_registration.Repo;

import com.apexcify.event_registration.Pojo.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    Optional<User> findByEmail(String email);
}