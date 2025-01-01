package com.example.order.dto;

import com.example.order.pojos.OrderLine;
import com.example.order.pojos.PaymentMethod;
import com.example.order.product.PurchaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.List;
public class OrderDTO {
    @JsonIgnore
    private int id;
    private String reference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private List<OrderLine> orderLines;
    String customerID;
    List<PurchaseRequest> products;

    public OrderDTO() {
    }

    public OrderDTO(int id, String reference, BigDecimal totalAmount, PaymentMethod paymentMethod, List<OrderLine> orderLines, String customerID, List<PurchaseRequest> products) {
        this.id = id;
        this.reference = reference;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.orderLines = orderLines;
        this.customerID = customerID;
        this.products = products;
    }

    public List<PurchaseRequest> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseRequest> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentMethod=" + paymentMethod +
                ", orderLines=" + orderLines +
                ", customerID='" + customerID + '\'' +
                ", products=" + products +
                '}';
    }
}
