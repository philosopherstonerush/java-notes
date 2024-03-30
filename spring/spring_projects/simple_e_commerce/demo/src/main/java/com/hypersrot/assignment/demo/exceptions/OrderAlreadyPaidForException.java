package com.hypersrot.assignment.demo.exceptions;

public class OrderAlreadyPaidForException extends RuntimeException{
    private Long userId;
    private Long orderId;

    public OrderAlreadyPaidForException(Long userId, Long orderId) {
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
