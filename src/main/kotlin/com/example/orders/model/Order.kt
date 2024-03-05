package com.example.orders.model

import com.example.users.model.User
import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val orderNumber: String = "",
    val orderDate: String = "",
    val email: String = "",
)

