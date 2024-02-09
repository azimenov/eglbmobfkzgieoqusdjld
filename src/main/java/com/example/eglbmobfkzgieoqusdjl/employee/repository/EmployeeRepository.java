package com.example.eglbmobfkzgieoqusdjl.employee.repository;

import com.example.eglbmobfkzgieoqusdjl.customer.model.Customer;
import com.example.eglbmobfkzgieoqusdjl.employee.model.Employee;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    Employee getById(ObjectId employeeId);



    @Aggregation(pipeline = {
            "{'$skip' : ?0 }",
            "{ '$limit' : ?1 }"
    })
    List<Employee> findAllWithFilter(int skip, int limit);

    Optional<Employee> findById(ObjectId id);

    boolean existsById(ObjectId employeeId);

    Employee save(Employee employee);

    void deleteById(ObjectId id);


}
