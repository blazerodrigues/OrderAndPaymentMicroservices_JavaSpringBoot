package com.blaze.os.api.repository;

import com.blaze.os.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//creating INTERFACE OrderRepository, extending JpaRepository<EntityName, PrimaryKey type of entity>
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
