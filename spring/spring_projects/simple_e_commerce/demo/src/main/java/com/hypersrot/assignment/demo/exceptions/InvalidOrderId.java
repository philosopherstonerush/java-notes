package com.hypersrot.assignment.demo.exceptions;

public class InvalidOrderId extends RuntimeException{

    private Long userId;
    private Long orderId;

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


    public InvalidOrderId(Long userId, Long orderId) {
        super();
        this.orderId = orderId;
        this.userId = userId;
    }
}
