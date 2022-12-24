package com.fone.filmone.application.auth

import com.fone.filmone.domain.user.service.RegisterUserService
import com.fone.filmone.presentation.auth.SignUpDto.SignUpRequest
import com.fone.filmone.presentation.auth.SignUpDto.SignUpResponse
import org.springframework.stereotype.Service

@Service
class SignUpFacade(
    private val registerUserService: RegisterUserService,
) {

    suspend fun signUp(request: SignUpRequest): SignUpResponse {
        val response = registerUserService.registerUser(request)

        return response
    }
}