package com.michael.ecommerce.repositories;

import com.michael.ecommerce.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String>{
}
