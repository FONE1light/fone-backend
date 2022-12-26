package com.fone.filmone.presentation.auth

import com.fone.filmone.domain.user.User
import com.fone.filmone.domain.user.enum.SocialLoginType

class SignInDto {

    data class SignInRequest(
        val socialLoginType: SocialLoginType,
        val email: String,
    )

    data class SignInResponse(
        val socialLoginType: SocialLoginType,
        val email: String,
        val accessToken: String,
    ) {

        constructor(
            user: User,
            accessToken: String,
        ) : this(
            socialLoginType = user.socialLoginType,
            email = user.email,
            accessToken = accessToken
        )
    }
}