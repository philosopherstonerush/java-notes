package com.hypersrot.assignment.demo.entity.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record InventoryRecordJson(int ordered, float price, int available) {
}
