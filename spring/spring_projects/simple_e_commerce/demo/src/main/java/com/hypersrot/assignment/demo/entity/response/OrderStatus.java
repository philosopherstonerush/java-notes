package com.hypersrot.assignment.demo.entity.response;

public record OrderStatus(Long orderId, float amount, String date, String coupon, String transactionId, String status) {
}
