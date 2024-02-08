package com.example.eglbmobfkzgieoqusdjl.employee.repository;

import com.example.eglbmobfkzgieoqusdjl.customer.model.Customer;
import com.example.eglbmobfkzgieoqusdjl.employee.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    Employee getById(ObjectId employeeId);
}
