package com.fone.filmone.domain.user.service

import com.fone.filmone.common.exception.UserNotFoundException
import com.fone.filmone.infrastructure.user.UserRepository
import com.fone.filmone.presentation.auth.SignInDto.SignInRequest
import com.fone.filmone.presentation.auth.SignInDto.SignInResponse
import org.springframework.stereotype.Service

@Service
class RetrieveUserService(
    private val userRepository: UserRepository,
) {

    suspend fun retrieveUser(request: SignInRequest): SignInResponse {
        with(request) {
            val user = userRepository.findByEmailAndSocialLoginType(
                email,
                socialLoginType.toString()
            ) ?: throw UserNotFoundException()

            return SignInResponse(user, "accessToken")
        }
    }
}