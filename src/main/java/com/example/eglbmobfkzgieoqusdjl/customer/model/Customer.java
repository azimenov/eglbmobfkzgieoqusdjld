package com.example.eglbmobfkzgieoqusdjl.customer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
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
