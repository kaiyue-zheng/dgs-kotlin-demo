package com.example.users.repository

import com.example.users.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int>{
    // custom query methods 
    fun deleteUserByEmail(email: String)
    fun findUserByEmail(email: String): User?
}
