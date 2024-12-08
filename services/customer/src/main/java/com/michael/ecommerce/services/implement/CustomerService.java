package com.michael.ecommerce.services.implement;

import com.michael.ecommerce.exception.GlobalExceptionHandler;
import com.michael.ecommerce.pojos.Customer;
import com.michael.ecommerce.repositories.CustomerRepo;
import com.michael.ecommerce.services.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Customer with id " + id + " not found")
        );
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer updatedCustomer = customerRepo.findById(customer.getId()).orElseThrow(
                () -> new EntityNotFoundException("Customer not found !"));
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customer = customerRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Customer not found !")
        );
        customerRepo.delete(customer);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepo.save(customer);
    }
}
