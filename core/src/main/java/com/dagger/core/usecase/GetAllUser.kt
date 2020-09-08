package com.dagger.core.usecase

import com.dagger.core.repository.UserRepository

class GetAllUser (private val userRepository: UserRepository) {

    suspend operator fun invoke() = userRepository.getAllUsers()

}