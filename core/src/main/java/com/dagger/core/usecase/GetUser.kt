package com.dagger.core.usecase

import com.dagger.core.repository.UserRepository

class GetUser (private val userRepository: UserRepository) {

    suspend operator fun invoke(id : Long) = userRepository.getUser(id)

}