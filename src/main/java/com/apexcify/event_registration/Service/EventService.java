package com.apexcify.event_registration.Service;

import com.apexcify.event_registration.Pojo.Event;
import com.apexcify.event_registration.Repo.EventRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;
// Get all events
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
    // event by ID
    public Event getEventById(String id) {
        Optional<Event> idevent= eventRepo.findById(new ObjectId(id));
        if(idevent.isPresent()){
            return idevent.get();
        }
        else{ return null;
    }}
// Create new event
    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }
// Delete event by ID
    public boolean deleteEvent(String id) {
        ObjectId objectId = new ObjectId(id);
        if (!eventRepo.existsById(objectId)) {
            throw new IllegalArgumentException("Event not found");
        }
        eventRepo.deleteById(objectId);
        return true;
    }
}