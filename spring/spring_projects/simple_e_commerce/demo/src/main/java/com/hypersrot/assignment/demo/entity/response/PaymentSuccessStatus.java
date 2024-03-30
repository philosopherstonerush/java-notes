package com.hypersrot.assignment.demo.entity.response;

public record PaymentSuccessStatus(Long userId, Long orderId, String transactionId, String status) {
}
