package com.michael.ecommerce.dtos;

import com.michael.ecommerce.pojos.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class CustomerDTO {
    @NotNull(message = "ID cannot be null !")
    private String id;

    @NotEmpty(message = "firstname is required !")
    private String firstName;

    @NotEmpty(message = "lastname is required !")
    private String lastName;

    @Email(message = "Email is wrong format")
    private String email;

    @NotNull(message = "Customer address is required")
    private Address address;
}
