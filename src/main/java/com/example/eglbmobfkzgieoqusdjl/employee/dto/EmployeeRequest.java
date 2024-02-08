package com.example.eglbmobfkzgieoqusdjl.employee.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeRequest {
    private String username;
    private int year;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
}
