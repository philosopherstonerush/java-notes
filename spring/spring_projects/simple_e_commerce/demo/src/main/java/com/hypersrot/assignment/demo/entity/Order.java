package com.hypersrot.assignment.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class Order {

    public Order() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="shop_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    private int quantityOrdered;

    private String status;

    private String transactionId;

    private float total;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity_ordered() {
        return quantityOrdered;
    }

    public void setQuantity_ordered(int quantity_ordered) {
        this.quantityOrdered = quantity_ordered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransaction_id() {
        return transactionId;
    }

    public void setTransaction_id(String transaction_id) {
        this.transactionId = transaction_id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
