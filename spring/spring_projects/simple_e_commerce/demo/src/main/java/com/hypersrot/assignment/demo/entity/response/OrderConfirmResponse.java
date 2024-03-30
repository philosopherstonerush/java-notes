package com.hypersrot.assignment.demo.entity.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record OrderConfirmResponse(Long orderId, Long userId, int quantity, float amount, String coupon) {
}
