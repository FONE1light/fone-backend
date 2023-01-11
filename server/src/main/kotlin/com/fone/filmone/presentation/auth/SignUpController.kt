package com.fone.filmone.presentation.auth

import com.fone.filmone.application.auth.SignUpFacade
import com.fone.filmone.common.response.CommonResponse
import com.fone.filmone.presentation.auth.SignUpDto.SignUpRequest
import com.fone.filmone.presentation.auth.SignUpDto.SignUpResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/user")
class SignUpController(
    private val signUpFacade: SignUpFacade,
) {

    @PostMapping("/sign-up")
    suspend fun signUp(@Valid @RequestBody request: SignUpRequest): CommonResponse<SignUpResponse> {
        val response = signUpFacade.signUp(request)
        return CommonResponse.success(response)
    }
}