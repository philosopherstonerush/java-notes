package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.entity.Inventory;
import com.hypersrot.assignment.demo.entity.Order;
import com.hypersrot.assignment.demo.entity.Product;
import com.hypersrot.assignment.demo.repositories.InventoryRepository;
import com.hypersrot.assignment.demo.repositories.OrderRepository;
import com.hypersrot.assignment.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @Autowired
    InventoryService(InventoryRepository inventoryRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void saveTheInventory(Inventory in) {
        this.inventoryRepository.save(in);
    }

    public int getQuantity(Long product_id) {
        var in = this.inventoryRepository.findInventoryByProductId(product_id);
        return in.getQuantity();
    }

    public int getOrderedQuantity(Long product_id) {
        var orders = this.orderRepository.findAllByProductId(product_id);

        return orders.stream()
                .map(Order::getQuantity_ordered)
                .reduce(0, Integer::sum);

    }

    public float getPriceOfProduct(Long product_id) {
        return productRepository
                .findById(product_id)
                .stream()
                .map(Product::getPrice)
                .findFirst()
                .get();
    }

    public int getAvailableQuantity(Long product_id) {
        int quant = this.getQuantity(product_id);
        int orderedQuant = this.getOrderedQuantity(product_id);
        return quant - orderedQuant;
    }


}
