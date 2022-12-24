package com.fone.filmone.application.auth

import com.fone.filmone.domain.user.service.RegisterUserService
import com.fone.filmone.idl.user.v1.auth.AuthServiceGrpcKt
import com.fone.filmone.idl.user.v1.auth.SignUpRequest
import com.fone.filmone.idl.user.v1.auth.SignUpResponse
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val registerUserService: RegisterUserService,
) : AuthServiceGrpcKt.AuthServiceCoroutineImplBase() {

    override suspend fun signUp(request: SignUpRequest): SignUpResponse {
        val userInfo = registerUserService.registerUser(request)

        return SignUpResponse.newBuilder().apply {
            job = userInfo.job
            addAllInterests(userInfo.interests.split(",").toList())
            nickname = userInfo.nickname
            birthday = userInfo.birthday
            gender = userInfo.gender
            profileUrl = userInfo.profileUrl
            phoneNumber = userInfo.phoneNumber
            email = userInfo.email
            providerType = userInfo.providerType
        }.build()
    }
}