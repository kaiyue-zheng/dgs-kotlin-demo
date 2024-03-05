package com.example.orders.repository

import com.example.orders.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>{
    fun findByEmail(email: String): List<Order>
}