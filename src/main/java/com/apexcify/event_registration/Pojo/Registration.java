package com.apexcify.event_registration.Pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "registrations")
public class Registration {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private ObjectId eventId;
    private String status = "REGISTERED"; // REGISTERED, CANCELLED
    private LocalDateTime registrationDate = LocalDateTime.now();
}