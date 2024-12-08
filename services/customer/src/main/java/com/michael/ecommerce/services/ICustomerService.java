package com.michael.ecommerce.services;

import com.michael.ecommerce.pojos.Customer;
import com.michael.ecommerce.repositories.CustomerRepo;

import java.util.List;

public interface ICustomerService{
    public List<Customer> getAllCustomer();
    public Customer getCustomerById(String id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(String id);
    public void createCustomer(Customer customer);

}
