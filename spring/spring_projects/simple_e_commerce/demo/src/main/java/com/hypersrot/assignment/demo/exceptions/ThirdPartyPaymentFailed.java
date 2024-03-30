package com.hypersrot.assignment.demo.exceptions;

import com.hypersrot.assignment.demo.api.ThirdPartyStatus;

public class ThirdPartyPaymentFailed extends Throwable {

    private ThirdPartyStatus thirdPartyStatus;
    private Long userId;
    private Long orderId;
    public ThirdPartyPaymentFailed(ThirdPartyStatus status, Long userId, Long orderId) {
        super();
        thirdPartyStatus = status;
        this.userId = userId;
        this.orderId = orderId;
    }

    public ThirdPartyStatus getThirdPartyStatus() {
        return thirdPartyStatus;
    }

    public void setThirdPartyStatus(ThirdPartyStatus thirdPartyStatus) {
        this.thirdPartyStatus = thirdPartyStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
