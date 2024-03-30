package com.hypersrot.assignment.demo.repositories;

import com.hypersrot.assignment.demo.entity.Inventory;
import com.hypersrot.assignment.demo.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    Inventory findInventoryByProductId(long id);

}
