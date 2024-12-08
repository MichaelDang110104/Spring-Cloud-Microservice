package com.michael.ecommerce.controllers;

import com.michael.ecommerce.configurations.ModelMapperConfiguration;
import com.michael.ecommerce.dtos.CustomerDTO;
import com.michael.ecommerce.pojos.Customer;
import com.michael.ecommerce.response.ResponseHandler;
import com.michael.ecommerce.services.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final ICustomerService iCustomerService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/create-customer")
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        iCustomerService.createCustomer(customer);
        return ResponseHandler.responseBuilder("Create customer successfully !", HttpStatus.CREATED,customer);
    }
    @GetMapping("/get-all-customer")
    public ResponseEntity<Object> getAllCustomer(){
        List<Customer> customers = iCustomerService.getAllCustomer();
        return ResponseHandler.responseBuilder("Get all customers", HttpStatus.OK,customers);
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Object> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        iCustomerService.updateCustomer(customer);
        return ResponseHandler.responseBuilder("Update customer successfully !",HttpStatus.CREATED,customer);
    }

    @DeleteMapping("/delete-customer")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String id){
        Customer customer = iCustomerService.getCustomerById(id);
        iCustomerService.deleteCustomer(id);
        return ResponseHandler.responseBuilder("Delete customer successfully !",HttpStatus.OK,customer);
    }

    @GetMapping("/get-customer")
    public ResponseEntity<Object> getCustomerById(@PathVariable String id){
        Customer customer = iCustomerService.getCustomerById(id);
        return ResponseHandler.responseBuilder("Delete customer successfully !",HttpStatus.OK,customer);
    }
}
