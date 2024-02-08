package com.example.eglbmobfkzgieoqusdjl.customer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    private String username;
    private int year;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private LocalDateTime createdAt;
}
