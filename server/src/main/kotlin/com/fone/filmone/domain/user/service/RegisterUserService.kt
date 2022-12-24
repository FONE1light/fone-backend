package com.fone.filmone.domain.user.service

import com.fone.filmone.domain.user.User
import com.fone.filmone.domain.user.UserInfo
import com.fone.filmone.idl.user.v1.auth.SignUpRequest
import com.fone.filmone.infrastructure.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegisterUserService(
    private val userRepository: UserRepository,
) {

    suspend fun registerUser(request: SignUpRequest): UserInfo.Main {
        val user = User(
            job = request.job,
            interests = "a,b",
            nickname = request.nickname,
            birthday = request.birthday,
            gender = request.gender,
            profileUrl = request.profileUrl,
            phoneNumber = request.phoneNumber,
            email = request.email,
            providerType = request.providerType,
        )
        userRepository.save(user)

        return UserInfo.Main(
            job = user.job,
            interests = user.interests,
            nickname = user.nickname,
            birthday = user.birthday,
            gender = user.gender,
            profileUrl = user.profileUrl,
            phoneNumber = user.phoneNumber,
            email = user.email,
            providerType = user.providerType,
        )
    }
}