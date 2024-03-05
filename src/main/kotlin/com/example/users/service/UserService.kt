package com.example.users.service

import com.example.users.model.User
import com.example.users.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    fun getUserByEmail(email:String): User? {
        return userRepository.findUserByEmail(email)
    } 

    fun createUser(name:String, email:String): User {
        val newUser = User(name=name, email=email)
        return userRepository.save(newUser)
    }

    @Transactional
    fun deleteUserByEmail(email:String) {
        userRepository.deleteUserByEmail(email)
    }
}