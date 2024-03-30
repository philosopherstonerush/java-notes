package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.entity.Coupon;
import com.hypersrot.assignment.demo.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CouponService {

    final private CouponRepository couponRepository;

    @Autowired
    CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    void saveTheCoupon(Coupon c) {
        this.couponRepository.save(c);
    }

    public Iterable<Coupon> getAllCoupons() {
        return this.couponRepository.findAll();
    }

}
