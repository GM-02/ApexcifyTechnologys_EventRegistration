package com.apexcify.event_registration.Repo;

import com.apexcify.event_registration.Pojo.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepo extends MongoRepository<Event, ObjectId> {
    List<Event> findByTitleContainingIgnoreCase(String title);

}