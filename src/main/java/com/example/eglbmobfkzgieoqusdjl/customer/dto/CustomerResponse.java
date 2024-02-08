package com.example.eglbmobfkzgieoqusdjl.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String username;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private int year;
}