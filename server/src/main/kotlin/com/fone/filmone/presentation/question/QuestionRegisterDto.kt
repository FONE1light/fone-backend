package com.fone.filmone.presentation.question

import com.fone.filmone.domain.question.enum.Type

class QuestionRegisterDto {

    data class QuestionRegisterRequest(
        val email: String,
        val type: Type,
        val title: String,
        val description: String,
        val agreeToPersonalInformation: Boolean,
    )

    data class QuestionRegisterResponse(
        val email: String,
        val type: Type,
        val title: String,
        val description: String,
        val agreeToPersonalInformation: Boolean,
    )
}