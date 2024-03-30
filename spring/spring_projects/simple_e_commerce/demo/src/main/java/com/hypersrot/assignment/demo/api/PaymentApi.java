package com.hypersrot.assignment.demo.api;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class PaymentApi {

    PaymentApi(){}

    public ThirdPartyStatus mockMyPayment() {

        Random random = new Random();


        List<ThirdPartyStatus> thirdPartyStatuses = Arrays.asList(new ThirdPartyStatus(getTransactionId(), "successful", "", 200), new ThirdPartyStatus(getTransactionId(), "failed", "Payment Failed from bank", 400), new ThirdPartyStatus(getTransactionId(), "failed", "No response from payment server", 504));

        return thirdPartyStatuses.get(random.nextInt(thirdPartyStatuses.size()));

    }

    public static String getTransactionId() {
        Random random = new Random();
        return "tran" + Integer.toBinaryString(random.nextInt());
    }

}
