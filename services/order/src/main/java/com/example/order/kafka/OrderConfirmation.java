package com.example.order.kafka;

import com.example.order.customer.customerDTO.CustomerDTO;
import com.example.order.pojos.PaymentMethod;
import com.example.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public class OrderConfirmation {
    private String orderReference;
    private BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    CustomerDTO customerDTO;
    List<PurchaseResponse> products;

    public OrderConfirmation() {
    }

    public OrderConfirmation(String orderReference, BigDecimal totalAmount, PaymentMethod paymentMethod, CustomerDTO customerDTO, List<PurchaseResponse> products) {
        this.orderReference = orderReference;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.customerDTO = customerDTO;
        this.products = products;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<PurchaseResponse> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseResponse> products) {
        this.products = products;
    }
}
