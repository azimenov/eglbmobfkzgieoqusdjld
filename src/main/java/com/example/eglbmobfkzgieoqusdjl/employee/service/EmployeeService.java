package com.example.eglbmobfkzgieoqusdjl.employee.service;

import com.example.eglbmobfkzgieoqusdjl.employee.dto.EmployeeRequest;
import com.example.eglbmobfkzgieoqusdjl.employee.dto.EmployeeResponse;
import com.example.eglbmobfkzgieoqusdjl.employee.model.Employee;
import com.example.eglbmobfkzgieoqusdjl.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .username(request.getUsername())
                .firstPhoneNumber(request.getFirstPhoneNumber())
                .secondPhoneNumber(request.getSecondPhoneNumber())
                .year(request.getYear())
                .createdAt(LocalDateTime.now())
                .build();
        EmployeeResponse response = EmployeeResponse.builder()
                .username(request.getUsername())
                .firstPhoneNumber(request.getFirstPhoneNumber())
                .secondPhoneNumber(request.getSecondPhoneNumber())
                .year(request.getYear())
                .build();
        repository.save(employee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<EmployeeResponse> deleteById(ObjectId id) {

        Optional<Employee> employee = repository.findById(id);
        repository.deleteById(id);
        if (employee.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(EmployeeResponse.builder()
                    .username(employee.get().getUsername())
                    .firstPhoneNumber(employee.get().getFirstPhoneNumber())
                    .secondPhoneNumber(employee.get().getSecondPhoneNumber())
                    .year(employee.get().getYear())
                    .build());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<EmployeeResponse> getById(ObjectId id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(EmployeeResponse.builder()
                    .username(employee.get().getUsername())
                    .firstPhoneNumber(employee.get().getFirstPhoneNumber())
                    .secondPhoneNumber(employee.get().getSecondPhoneNumber())
                    .year(employee.get().getYear())
                    .build());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<EmployeeResponse> updateCustomer(EmployeeRequest request, ObjectId employeeId) {
        if (repository.existsById((employeeId))) {
            Employee employee= repository.getById(employeeId);

            copy(request, employee);

            Employee employee1 = repository.save(employee);

            return ResponseEntity.ok(EmployeeResponse.builder()
                    .username(employee1.getUsername())
                    .year(employee1.getYear())
                    .firstPhoneNumber(employee1.getFirstPhoneNumber())
                    .secondPhoneNumber(employee1.getSecondPhoneNumber())
                    .build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void copy(EmployeeRequest request, Employee employee){
        if(request.getUsername() != null){
            employee.setUsername(request.getUsername());
        }
        if(request.getFirstPhoneNumber() != null){
            employee.setFirstPhoneNumber(request.getFirstPhoneNumber());
        }
        if(request.getSecondPhoneNumber() != null){
            employee.setSecondPhoneNumber(request.getSecondPhoneNumber());
        }
        if(request.getYear() != 0){
            employee.setYear(request.getYear());
        }
    }

}
