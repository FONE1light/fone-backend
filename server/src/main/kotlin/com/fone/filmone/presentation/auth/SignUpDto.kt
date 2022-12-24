package com.fone.filmone.presentation.auth

import com.fone.filmone.domain.user.enum.Gender
import com.fone.filmone.domain.user.enum.Interest
import com.fone.filmone.domain.user.enum.Job
import com.fone.filmone.domain.user.enum.SocialLoginType

class SignUpDto {

    data class SignUpRequest(
        val job: Job,
        val interests: List<Interest>,
        val nickname: String,
        val birthday: String,
        val gender: Gender,
        val profileUrl: String,
        val phoneNumber: String,
        val email: String,
        val socialLoginType: SocialLoginType,
        val agreeToTermsOfServiceTermsOfUse: Boolean,
        val agreeToPersonalInformation: Boolean,
        val isReceiveMarketing: Boolean,
    )

    data class SignUpResponse(
        val job: Job,
        val interests: List<Interest>,
        val nickname: String,
        val birthday: String,
        val gender: Gender,
        val profileUrl: String,
        val phoneNumber: String,
        val email: String,
        val socialLoginType: SocialLoginType,
        val agreeToTermsOfServiceTermsOfUse: Boolean,
        val agreeToPersonalInformation: Boolean,
        val isReceiveMarketing: Boolean,
        val accessToken: String,
    )
}