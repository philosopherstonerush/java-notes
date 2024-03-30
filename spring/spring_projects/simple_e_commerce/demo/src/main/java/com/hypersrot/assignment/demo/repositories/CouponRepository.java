package com.hypersrot.assignment.demo.repositories;

import com.hypersrot.assignment.demo.entity.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
    Coupon findByCouponName(String name);
}
