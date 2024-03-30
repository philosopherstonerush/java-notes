package com.hypersrot.assignment.demo.controllers;

import com.hypersrot.assignment.demo.api.PaymentApi;
import com.hypersrot.assignment.demo.entity.response.PaymentSuccessStatus;
import com.hypersrot.assignment.demo.exceptions.ThirdPartyPaymentFailed;
import com.hypersrot.assignment.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentApi paymentApi, PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{id}/{orderId}/pay")
    public PaymentSuccessStatus makePayment(@PathVariable("id") Long userId, @PathVariable("orderId") Long orderId, @RequestParam("amount") float amount) throws ThirdPartyPaymentFailed {

        return paymentService.processPayment(userId, orderId, amount);

    }

}
