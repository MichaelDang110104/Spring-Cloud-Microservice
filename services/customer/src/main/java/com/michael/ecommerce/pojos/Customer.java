package com.michael.ecommerce.pojos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Customer {
    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "address")
    private Address address;

}
