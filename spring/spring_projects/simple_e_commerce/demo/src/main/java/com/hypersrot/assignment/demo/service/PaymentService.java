package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.api.PaymentApi;
import com.hypersrot.assignment.demo.api.ThirdPartyStatus;
import com.hypersrot.assignment.demo.entity.Order;
import com.hypersrot.assignment.demo.entity.response.PaymentSuccessStatus;
import com.hypersrot.assignment.demo.exceptions.InvalidAmount;
import com.hypersrot.assignment.demo.exceptions.InvalidOrderId;
import com.hypersrot.assignment.demo.exceptions.OrderAlreadyPaidForException;
import com.hypersrot.assignment.demo.exceptions.ThirdPartyPaymentFailed;
import com.hypersrot.assignment.demo.repositories.OrderRepository;
import com.hypersrot.assignment.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentApi paymentApi;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PaymentService(PaymentApi paymentApi, UserRepository userRepository, OrderRepository orderRepository) {
        this.paymentApi = paymentApi;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public PaymentSuccessStatus processPayment(Long userId, Long orderId, float amount) throws ThirdPartyPaymentFailed {

        Optional<Order> order = orderRepository.findById(orderId);

        if(order.isEmpty()) throw new InvalidOrderId(userId, orderId);
        float amountToBePaid = order.get().getTotal();
        if(amount != amountToBePaid) throw new InvalidAmount(userId, orderId);
        if(order.get().getStatus().equals("paid")) throw new OrderAlreadyPaidForException(userId, orderId);

        ThirdPartyStatus status = paymentApi.mockMyPayment();

        if(status.statusCode() == 200) {

            Order updatedOrder = order.get();
            updatedOrder.setStatus("paid");
            updatedOrder.setTransaction_id(status.transactionId());
            orderRepository.save(updatedOrder);

            return new PaymentSuccessStatus(userId, orderId, status.transactionId(), status.status());

        }

        throw new ThirdPartyPaymentFailed(status, userId, orderId);

    }
}
