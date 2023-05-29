package com.bjit.orderapp.repository;

import com.bjit.orderapp.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    OrderEntity findByOrderID(Integer orderId);
}
