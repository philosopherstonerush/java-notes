package com.hypersrot.assignment.demo.exceptions;

public class InvalidorderIdForStatus extends RuntimeException {

    private Long orderId;

    public InvalidorderIdForStatus(Long orderId) {
        this.orderId = orderId;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
