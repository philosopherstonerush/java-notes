package com.hypersrot.assignment.demo.controllers;

import com.hypersrot.assignment.demo.entity.response.InventoryRecordJson;
import com.hypersrot.assignment.demo.service.InventoryService;
import com.hypersrot.assignment.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    final InventoryService inventoryService;

    @Autowired
    InventoryController(InventoryService inventoryService, OrderService orderService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
    public InventoryRecordJson getInventory() {
        int quantity = inventoryService.getQuantity(1L);
        int ordered = inventoryService.getOrderedQuantity(1L);
        int available = quantity - ordered;
        float price = inventoryService.getPriceOfProduct(1L);
        return new InventoryRecordJson(ordered, price, quantity - ordered);
    }

}

// Done by Suvarna Narayanan Baratharaj