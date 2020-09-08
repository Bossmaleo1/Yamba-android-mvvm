package com.dagger.core.usecase

import com.dagger.core.data.User
import com.dagger.core.repository.UserRepository

class RemoveUser(private val userRepository: UserRepository)  {

    suspend operator fun invoke(user : User) = userRepository.removeUser(user)
}