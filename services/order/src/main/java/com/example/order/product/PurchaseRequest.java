package com.example.order.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PurchaseRequest {
    Integer productId;
    double quantity;

    public PurchaseRequest(Integer productId, double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public PurchaseRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
