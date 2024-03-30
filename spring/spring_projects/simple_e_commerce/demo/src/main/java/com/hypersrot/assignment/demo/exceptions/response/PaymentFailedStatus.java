package com.hypersrot.assignment.demo.exceptions.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record PaymentFailedStatus(String transactionId, String status, String description, Long userId, Long orderId){}
