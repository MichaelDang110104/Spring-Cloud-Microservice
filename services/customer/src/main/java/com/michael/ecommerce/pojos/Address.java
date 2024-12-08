package com.michael.ecommerce.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "Address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Validated
public class Address {
    @Id
    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "customer")
    private Customer customer;
}
