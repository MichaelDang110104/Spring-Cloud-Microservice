package com.michael.ecommerce.repositories;

import com.michael.ecommerce.pojos.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepo extends MongoRepository<Customer,String> {
}
