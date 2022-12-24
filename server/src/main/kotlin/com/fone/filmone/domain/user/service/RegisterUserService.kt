package com.fone.filmone.domain.user.service

import com.fone.filmone.domain.user.User
import com.fone.filmone.domain.user.enum.Interest
import com.fone.filmone.infrastructure.user.UserRepository
import com.fone.filmone.presentation.auth.SignUpDto.SignUpRequest
import com.fone.filmone.presentation.auth.SignUpDto.SignUpResponse
import org.springframework.stereotype.Service

@Service
class RegisterUserService(
    private val userRepository: UserRepository,
) {

    suspend fun registerUser(request: SignUpRequest): SignUpResponse {
        val user = User(
            job = request.job,
            interests = request.interests.joinToString(","),
            nickname = request.nickname,
            birthday = request.birthday,
            gender = request.gender,
            profileUrl = request.profileUrl,
            phoneNumber = request.phoneNumber,
            email = request.email,
            socialLoginType = request.socialLoginType,
            agreeToTermsOfServiceTermsOfUse = request.agreeToTermsOfServiceTermsOfUse,
            agreeToPersonalInformation = request.agreeToPersonalInformation,
            isReceiveMarketing = request.isReceiveMarketing,
        )
        userRepository.save(user)

        return SignUpResponse(
            job = user.job,
            interests = user.interests.split(",").map{Interest(it)}.toList(),
            nickname = user.nickname,
            birthday = user.birthday,
            gender = user.gender,
            profileUrl = user.profileUrl,
            phoneNumber = user.phoneNumber,
            email = user.email,
            socialLoginType = user.socialLoginType,
            agreeToTermsOfServiceTermsOfUse = user.agreeToTermsOfServiceTermsOfUse,
            agreeToPersonalInformation = user.agreeToPersonalInformation,
            isReceiveMarketing = user.isReceiveMarketing,
            accessToken = "",
        )
    }
}