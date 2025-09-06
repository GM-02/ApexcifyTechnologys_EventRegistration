package com.apexcify.event_registration.Service;

import com.apexcify.event_registration.Pojo.Registration;
import com.apexcify.event_registration.Repo.EventRepo;
import com.apexcify.event_registration.Repo.RegRepo;
import com.apexcify.event_registration.Repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegRepo regRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    // Register user for event
    public Registration registerUser(String userId, String eventId) {
        ObjectId userObjectId = new ObjectId(userId);
        ObjectId eventObjectId = new ObjectId(eventId);

        // Check if user exists
        if (!userRepo.existsById(userObjectId)) {
            throw new RuntimeException("User does not exist");
        }

        // Check if event exists
        if (!eventRepo.existsById(eventObjectId)) {
            throw new RuntimeException("Event does not exist");
        }

        // Check if already registered (simple check)
        List<Registration> existingRegistrations = regRepo.findByUserIdAndEventId(userObjectId, eventObjectId);
        if (existingRegistrations != null && !existingRegistrations.isEmpty()) {
            // Check if any registration is still active
            for (Registration reg : existingRegistrations) {
                if ("REGISTERED".equals(reg.getStatus())) {
                    throw new RuntimeException("User already registered for this event");
                }
            }
        }

        // Create new registration
        Registration registration = new Registration();
        registration.setUserId(userObjectId);
        registration.setEventId(eventObjectId);
        registration.setStatus("REGISTERED");

        return regRepo.save(registration);
    }

    // Cancel registration
    public String cancelRegistration(String registrationId) {
        ObjectId regId = new ObjectId(registrationId);
        Optional<Registration> registrationOpt = regRepo.findById(regId);

        if (!registrationOpt.isPresent()) {
            throw new RuntimeException("Registration not found");
        }

        Registration registration = registrationOpt.get();
        registration.setStatus("CANCELLED");
        regRepo.save(registration);
        return "Registration cancelled successfully";
    }

    // all registrations
    public List<Registration> getAllRegistrations() {
        return regRepo.findAll();
    }
    // registration by ID
    public Optional<Registration> getRegistrationById(String id) {
        return regRepo.findById(new ObjectId(id));
    }
    // user registrations
    public List<Registration> getUserRegistrations(String userId) {
        return regRepo.findByUserId(new ObjectId(userId));
    }
    // get event registrations
    public List<Registration> getEventRegistrations(String eventId) {
        return regRepo.findByEventId(new ObjectId(eventId));
    }
}