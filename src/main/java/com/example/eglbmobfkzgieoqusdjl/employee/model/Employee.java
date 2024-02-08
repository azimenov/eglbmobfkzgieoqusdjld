package com.example.eglbmobfkzgieoqusdjl.employee.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
public class Employee {
    @Id
    private ObjectId id;

    private String username;
    private int year;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private LocalDateTime createdAt;
}
