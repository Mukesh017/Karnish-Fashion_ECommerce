package com.karnish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karnish.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
