package com.hypersrot.assignment.demo.controllers;

import com.hypersrot.assignment.demo.entity.Coupon;
import com.hypersrot.assignment.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CouponController {

    private final CouponService couponService;

    @Autowired
    CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/fetchCoupons")
    public Map getCoupons() {

        Iterable<Coupon> allCoupons = couponService.getAllCoupons();

        HashMap<String, Integer> resp = new HashMap<>();

        for(var coup: allCoupons) {
            resp.put(coup.getCoupon_name(), coup.getDiscount_percentage());
        }

        return resp;
    }

}
