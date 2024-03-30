package com.hypersrot.assignment.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coupon")
public class Coupon {

    public String getCoupon_name() {
        return couponName;
    }

    public void setCoupon_name(String coupon_name) {
        this.couponName = coupon_name;
    }

    public int getDiscount_percentage() {
        return discoundPercentage;
    }

    public void setDiscount_percentage(int discount_percentage) {
        this.discoundPercentage = discount_percentage;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "coupon_name")
    private String couponName;
    @Column(name = "discount_percentage")
    private int discoundPercentage;
    @Column(name = "valid")
    private Boolean valid;


    public Coupon() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
