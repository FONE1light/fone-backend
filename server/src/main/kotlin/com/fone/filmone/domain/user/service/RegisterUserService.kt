package com.fone.filmone.domain.user.service

import com.fone.filmone.infrastructure.user.UserRepository
import com.fone.filmone.presentation.auth.SignUpDto.SignUpRequest
import com.fone.filmone.presentation.auth.SignUpDto.SignUpResponse
import org.springframework.stereotype.Service

@Service
class RegisterUserService(
    private val userRepository: UserRepository,
) {

    suspend fun registerUser(request: SignUpRequest): SignUpResponse {
        val user = request.toEntity()
        userRepository.save(user)

        return SignUpResponse(user)
    }
}