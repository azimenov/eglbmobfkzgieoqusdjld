package com.example.eglbmobfkzgieoqusdjl.employee.controller;

import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerRequest;
import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerResponse;
import com.example.eglbmobfkzgieoqusdjl.customer.service.CustomerService;
import com.example.eglbmobfkzgieoqusdjl.employee.dto.EmployeeRequest;
import com.example.eglbmobfkzgieoqusdjl.employee.dto.EmployeeResponse;
import com.example.eglbmobfkzgieoqusdjl.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request) {
        return service.createEmployee(request);
    }

    @DeleteMapping("/deleteEmployeeById")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@RequestParam ObjectId id) {
        return service.deleteById(id);
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<EmployeeResponse> getEmployee(@RequestParam ObjectId id) {
        return service.getById(id);
    }

    @PatchMapping("/updateCustomer/{customerId}")
    public ResponseEntity<EmployeeResponse> updateCustomer(@RequestBody EmployeeRequest request, @PathVariable ObjectId customerId) {
        return service.updateCustomer(request, customerId);
    }
}
