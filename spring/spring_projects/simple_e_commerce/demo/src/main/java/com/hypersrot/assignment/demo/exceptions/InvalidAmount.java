package com.hypersrot.assignment.demo.exceptions;

public class InvalidAmount extends RuntimeException{
    private Long userId;
    private Long orderId;

    public InvalidAmount(Long userId, Long orderId) {
        super();
        this.userId = userId;
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
