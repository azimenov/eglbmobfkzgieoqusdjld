package com.example.eglbmobfkzgieoqusdjl.customer.repository;

import com.example.eglbmobfkzgieoqusdjl.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="SELECT * FROM customer offset ?1 limit ?2", nativeQuery = true)
    public List<Customer> findWithLimitAndOffset(int offset, int limit);
}
