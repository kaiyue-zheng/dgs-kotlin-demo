package com.example.orders.service

import com.example.orders.model.Order
import com.example.orders.repository.OrderRepository
import org.springframework.stereotype.Service

@Service 
class OrderService(private val orderRepository: OrderRepository) {

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll().toList()
    }
    
    fun createOrder(orderNumber:String, email:String, orderDate:String): Order {
        val newOrder = Order(orderNumber=orderNumber, email = email, orderDate=orderDate)
        return orderRepository.save(newOrder)
    }

    fun getOrderByEmail(email:String): List<Order> {
        return orderRepository.findByEmail(email)
    }
}