package com.example.users.resolver

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery
import com.example.users.model.User
import com.example.users.service.UserService

@DgsComponent
class UserMutationResolver(private val userService: UserService) {
    
    @DgsQuery
    fun allUsers(): List<User> {
        return userService.getAllUsers()
    }

    @DgsQuery
    fun getUserByEmail(email: String): User? {
        return userService.getUserByEmail(email)
    }

    @DgsMutation
    fun createUser(input:CreateUserInput): User {
        return userService.createUser(input.name, input.email)
    }

    @DgsMutation
    fun deleteUserByEmail(email: String): Boolean {
        userService.deleteUserByEmail(email)
        return true
    }
}

data class CreateUserInput(
    val name: String,
    val email: String
)

