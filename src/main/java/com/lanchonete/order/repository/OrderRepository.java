package com.lanchonete.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanchonete.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

}
