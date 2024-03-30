package com.hypersrot.assignment.demo.controllers;

import com.hypersrot.assignment.demo.entity.Order;
import com.hypersrot.assignment.demo.entity.response.OrderConfirmResponse;
import com.hypersrot.assignment.demo.entity.response.OrderStatus;
import com.hypersrot.assignment.demo.entity.response.OrdersForUsers;
import com.hypersrot.assignment.demo.service.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{id}/order")
    public OrderConfirmResponse createOrder(@PathVariable("id") Long id, @RequestParam("qty") int quantity, @RequestParam("coupon") String coupon) throws Exception{

        orderService.verify(id, quantity, coupon);

        return orderService.createOrder(quantity, coupon, id);

    }

    @GetMapping("/{id}/orders")
    public List<OrdersForUsers> getOrdersForAUser(@PathVariable("id") Long userId) {
        orderService.verify(userId, null, null);
        return orderService.getOrders(userId);
    }

    @GetMapping("/{id}/orders/{orderId}")
    public OrderStatus getOrderStatusForUser(@PathVariable("id") Long userId, @PathVariable("orderId") Long orderId) {
        return orderService.getOrderStatus(userId, orderId);
    }

}
