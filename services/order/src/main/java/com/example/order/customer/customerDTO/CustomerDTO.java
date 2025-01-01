package com.example.order.customer.customerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CustomerDTO {
    @NotNull(message = "ID cannot be null !")
    private String id;

    @NotEmpty(message = "firstname is required !")
    private String firstName;

    @NotEmpty(message = "lastname is required !")
    private String lastName;

    @Email(message = "Email is wrong format")
    private String email;
}
