package com.example.order.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
    private int product_id;
    private double quantity;

    public OrderLine() {
    }

    public OrderLine(int id, Order order, int product_id, double quantity) {
        this.id = id;
        this.order = order;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", order=" + order +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
