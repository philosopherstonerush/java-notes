package com.hypersrot.assignment.demo.entity.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record OrdersForUsers(Long orderId, float amount, String date, String coupon) {
}
