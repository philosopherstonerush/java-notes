package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.entity.Coupon;
import com.hypersrot.assignment.demo.entity.Order;
import com.hypersrot.assignment.demo.entity.Product;
import com.hypersrot.assignment.demo.entity.User;
import com.hypersrot.assignment.demo.entity.response.OrderConfirmResponse;
import com.hypersrot.assignment.demo.entity.response.OrderStatus;
import com.hypersrot.assignment.demo.entity.response.OrdersForUsers;
import com.hypersrot.assignment.demo.exceptions.CouponNotFound;
import com.hypersrot.assignment.demo.exceptions.InvalidorderIdForStatus;
import com.hypersrot.assignment.demo.exceptions.NotEnoughProducts;
import com.hypersrot.assignment.demo.exceptions.UserNotFoundException;
import com.hypersrot.assignment.demo.repositories.CouponRepository;
import com.hypersrot.assignment.demo.repositories.OrderRepository;
import com.hypersrot.assignment.demo.repositories.ProductRepository;
import com.hypersrot.assignment.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final InventoryService inventoryService;
    private final CouponRepository couponRepository;
    private final ProductRepository productRepository;

    @Autowired
    OrderService(OrderRepository orderRepository, UserRepository userRepository, InventoryService inventoryService, CouponRepository couponRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.inventoryService = inventoryService;
        this.couponRepository = couponRepository;
        this.productRepository = productRepository;
    }

    public void saveTheOrder(Order o) {
        this.orderRepository.save(o);
    }

    public void verify(Long user_id, Integer quantity, String coupon) {

        if(user_id != null) {
            Optional<User> u = this.userRepository.findById(user_id);
            if(u.isEmpty()) throw new UserNotFoundException();
        }

        if(coupon != null) {
            if(!coupon.isEmpty()) {
                Optional<Coupon> c = Optional.ofNullable(this.couponRepository.findByCouponName(coupon));
                if(c.isEmpty()) throw new CouponNotFound();
            }
        }

        if(quantity != null) {
            int quantityAvailable = this.inventoryService.getAvailableQuantity(1L);
            if (quantity > quantityAvailable || quantity < 1) throw new NotEnoughProducts();
        }

    }

    public OrderConfirmResponse createOrder(int quantity, String coupon, Long id) {

        Order o = new Order();
        Product p = productRepository.findById(1L).get();
        User u = userRepository.findById(id).get();
        Coupon c = (coupon != null) ? couponRepository.findByCouponName(coupon): null;

        o.setProduct(p);
        o.setUser(u);
        o.setCoupon(c);
        o.setStatus("pending");
        o.setDate(LocalDate.now().toString());
        o.setQuantity_ordered(quantity);
        o.setTransaction_id(null);

        float total = (p.getPrice() * quantity);
        float discounted = (c != null) ? (total * c.getDiscount_percentage())/ 100: 0.0F;

        o.setTotal(total - discounted);

        Order order = orderRepository.save(o);

        return new OrderConfirmResponse(order.getId(), id, quantity, order.getTotal(), coupon);

    }

    public List<OrdersForUsers> getOrders(Long userId) {
        List<Order> orders = this.orderRepository.findAllByUserId(userId);

        return orders.stream()
                .map(this::convertOrderToOrderResponse)
                .collect(Collectors.toList());

    }

    private OrdersForUsers convertOrderToOrderResponse(Order o) {
        OrdersForUsers orders = new OrdersForUsers(o.getId(), o.getTotal(), o.getDate(), (o.getCoupon() != null) ? o.getCoupon().getCoupon_name(): null);
        return orders;
    }

    public OrderStatus getOrderStatus(Long userId, Long orderId) {

        this.verify(userId, null, null);

        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isEmpty()) {
            throw new InvalidorderIdForStatus(orderId);
        }

        Order presentOrder = order.get();

        return new OrderStatus(orderId, presentOrder.getTotal(), presentOrder.getDate(), (presentOrder.getCoupon() != null) ? presentOrder.getCoupon().getCoupon_name(): null, presentOrder.getTransaction_id(), presentOrder.getStatus());

    }
}
