package com.michael.product.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.michael.product.pojos.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDTO {
    private int id;
    @NotEmpty(message = "Product name cannot be empty")
    private String name;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    @Positive(message = "Quantity has to be bigger than 0")
    private double availableQuantity;
    @NotNull(message = "Price cannot be null ")
    @Positive(message = "Price has to be bigger than 0")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    @NotNull(message = "Category cannot be null")
    private Category category;



}
