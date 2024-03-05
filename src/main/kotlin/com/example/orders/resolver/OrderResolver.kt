package com.example.orders.resolver 

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsQuery 
import com.netflix.graphql.dgs.DgsMutation
import com.example.orders.model.Order
import com.example.orders.service.OrderService
import com.example.users.model.User
import com.example.users.service.UserService

@DgsComponent
class OrderResolver(
    private val orderService: OrderService, 
    private val userService: UserService) {
    
    @DgsQuery
    fun allOrders(): List<Order> {
        return orderService.getAllOrders()
    }

    @DgsQuery(field="getOrderByEmail")
    fun getOrderByEmail(email: String): List<OrderWithUser> {
        val user = userService.getUserByEmail(email) ?: return emptyList()
        val orders = orderService.getOrderByEmail(email) 
        return orders.map { OrderWithUser(it, user) }
    }

    @DgsMutation
    fun createOrder(input: CreateOrderInput): Order {
        return orderService.createOrder(input.orderNumber, input.email, input.orderDate)
    }

}

data class CreateOrderInput(
    val orderNumber: String,
    val email: String,
    val orderDate: String
)

data class OrderWithUser(val order: Order, val user: User)

