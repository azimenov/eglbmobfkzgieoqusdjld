package com.example.eglbmobfkzgieoqusdjl.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {
    private String username;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private int year;

    public CustomerRequest(String username, String firstPhoneNumber, String secondPhoneNumber, int year) {
        this.username = username;
        this.firstPhoneNumber = firstPhoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.year = year;
    }
}