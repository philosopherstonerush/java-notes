package com.hypersrot.assignment.demo.exceptions;

import com.hypersrot.assignment.demo.api.PaymentApi;
import com.hypersrot.assignment.demo.api.ThirdPartyStatus;
import com.hypersrot.assignment.demo.exceptions.response.PaymentFailedStatus;
import com.hypersrot.assignment.demo.exceptions.response.ErrResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ShopException {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class})
    @ResponseBody
    public ErrResponse handleUserNotFound(UserNotFoundException e) {
        return new ErrResponse("User not found");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotEnoughProducts.class})
    @ResponseBody
    public ErrResponse handleNotEnoughProducts() {
        return new ErrResponse("Quantity is either less than 1 or more than the maximum quantity of product available");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({CouponNotFound.class})
    @ResponseBody
    public ErrResponse handleInvalidCoupon(){
        return new ErrResponse("Invalid Coupon");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidOrderId.class})
    @ResponseBody
    public PaymentFailedStatus handleInvalidIDForPayment(InvalidOrderId invalidOrderId){
        return new PaymentFailedStatus(PaymentApi.getTransactionId(), "failed", "Payment Failed due to invalid order id", invalidOrderId.getUserId(), invalidOrderId.getOrderId());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidAmount.class})
    @ResponseBody
    public PaymentFailedStatus handleInvalidAmountForPayment(InvalidAmount invalidAmount){
        return new PaymentFailedStatus(PaymentApi.getTransactionId(), "failed", "Payment Failed due to invalid amount", invalidAmount.getUserId(), invalidAmount.getOrderId());
    }

    @ExceptionHandler({ThirdPartyPaymentFailed.class})
    @ResponseBody
    public ResponseEntity<PaymentFailedStatus> handleThirdPartyFailuresForPayment(ThirdPartyPaymentFailed thirdPartyPaymentFailed){
        ThirdPartyStatus thirdPartyStatus = thirdPartyPaymentFailed.getThirdPartyStatus();
        PaymentFailedStatus paymentFailedStatus = new PaymentFailedStatus(thirdPartyStatus.transactionId(), thirdPartyStatus.status(), thirdPartyStatus.description(), thirdPartyPaymentFailed.getUserId(), thirdPartyPaymentFailed.getOrderId());
        return ResponseEntity.status(thirdPartyStatus.statusCode()).body(paymentFailedStatus);
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({OrderAlreadyPaidForException.class})
    @ResponseBody
    public PaymentFailedStatus handleOrdersAlreadyPaidForPayment(OrderAlreadyPaidForException e){
        return new PaymentFailedStatus(PaymentApi.getTransactionId(), "failed", "Payment failed as order is already paid for", e.getUserId(), e.getOrderId());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({InvalidorderIdForStatus.class})
    @ResponseBody
    public Map handleOrdersAlreadyPaidForPayment(InvalidorderIdForStatus e){
        Map<String, String> map = new HashMap<>();

        map.put("orderId", e.getOrderId().toString());
        map.put("description", "Order not Found");

        return map;
    }

}
