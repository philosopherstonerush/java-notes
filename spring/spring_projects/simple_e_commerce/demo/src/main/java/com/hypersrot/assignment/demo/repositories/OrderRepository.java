package com.hypersrot.assignment.demo.repositories;

import com.hypersrot.assignment.demo.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByProductId(Long product_id);

    List<Order> findAllByUserId(Long userId);


}
