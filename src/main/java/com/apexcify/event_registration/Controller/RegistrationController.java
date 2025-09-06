package com.apexcify.event_registration.Controller;

import com.apexcify.event_registration.Pojo.Registration;
import com.apexcify.event_registration.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    // Register user
    @PostMapping("/{userId}/{eventId}")
    public ResponseEntity<?> registerUser(@PathVariable String userId, @PathVariable String eventId) {
        try {
            Registration registration = registrationService.registerUser(userId, eventId);
            return ResponseEntity.ok(registration);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Cancel registration
    @DeleteMapping("/{registrationId}")
    public ResponseEntity<String> cancelRegistration(@PathVariable String registrationId) {
        try {
            String message = registrationService.cancelRegistration(registrationId);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Get all registrations
    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrations);
    }
    // Get registration by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationById(@PathVariable String id) {
        try {
            Optional<Registration> registration = registrationService.getRegistrationById(id);
            if (registration.isPresent()) {
                return ResponseEntity.ok(registration.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all registrations of  user
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserRegistrations(@PathVariable String userId) {
        try {
            List<Registration> registrations = registrationService.getUserRegistrations(userId);
            return ResponseEntity.ok(registrations);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid user ID");
        }
    }

    // Get all registrations of event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<?> getEventRegistrations(@PathVariable String eventId) {
        try {
            List<Registration> registrations = registrationService.getEventRegistrations(eventId);
            return ResponseEntity.ok(registrations);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid event ID");
        }
    }
}