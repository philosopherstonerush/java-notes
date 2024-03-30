package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.entity.Coupon;
import com.hypersrot.assignment.demo.entity.Inventory;
import com.hypersrot.assignment.demo.entity.Product;
import com.hypersrot.assignment.demo.entity.User;
import com.hypersrot.assignment.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbInit implements CommandLineRunner {

    private final CouponService couponService;
    private final ProductService productService;
    private final InventoryService inventoryService;
    private final UserRepository userRepository;

    @Autowired
    DbInit(CouponService couponService, ProductService productService, InventoryService inventoryService, UserRepository userRepository) {
        this.couponService = couponService;
        this.productService = productService;
        this.inventoryService = inventoryService;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Coupon coupon1 = new Coupon();
        coupon1.setCoupon_name("OFF5");
        coupon1.setValid(true);
        coupon1.setDiscount_percentage(5);

        couponService.saveTheCoupon(coupon1);

        Coupon coupon2 = new Coupon();
        coupon2.setCoupon_name("OFF10");
        coupon2.setValid(true);
        coupon2.setDiscount_percentage(10);

        couponService.saveTheCoupon(coupon2);

        Product p1 = new Product();
		p1.setName("Some awesome product");
		p1.setPrice(1000);

        productService.saveTheProduct(p1);

        Inventory inventory = new Inventory();
		inventory.setQuantity(100);
		inventory.setProduct(p1);

		inventoryService.saveTheInventory(inventory);

        User user1 = new User();
		user1.setName("user1");
		User user2 = new User();
		user2.setName("user2");

		userRepository.saveAll(Arrays.asList(user1, user2));

    }
}
