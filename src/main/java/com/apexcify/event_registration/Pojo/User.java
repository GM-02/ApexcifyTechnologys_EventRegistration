package com.apexcify.event_registration.Pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "user")
@Data
public class User {
    @Id
    private ObjectId userId;
    private String userName;
    private String email;

}
