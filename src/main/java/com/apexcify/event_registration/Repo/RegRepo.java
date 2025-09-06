package com.apexcify.event_registration.Repo;

import com.apexcify.event_registration.Pojo.Registration;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegRepo extends MongoRepository<Registration, ObjectId> {
    List<Registration> findByUserId(ObjectId userId);
    List<Registration> findByEventId(ObjectId eventId);
    List<Registration> findByUserIdAndEventId(ObjectId userObjectId, ObjectId eventObjectId);
}