package com.michael.ecommerce.services;

import com.michael.ecommerce.pojos.Customer;
import com.michael.ecommerce.repositories.CustomerRepo;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomerById(String id);

    void updateCustomer(Customer customer);

    void deleteCustomer(String id);

    void createCustomer(Customer customer);

}
