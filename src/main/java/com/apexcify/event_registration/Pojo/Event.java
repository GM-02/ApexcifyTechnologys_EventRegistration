package com.apexcify.event_registration.Pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "events")
@Data
public class Event {
    @Id
    private ObjectId eventId;
    private String title;
    private LocalDate date;
    private String eventDescription;
    private String eventLocation;
}
