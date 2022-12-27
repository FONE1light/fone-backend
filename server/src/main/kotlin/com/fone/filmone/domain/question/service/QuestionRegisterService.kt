package com.fone.filmone.domain.question.service

import com.fone.filmone.presentation.question.QuestionRegisterDto.QuestionRegisterRequest
import com.fone.filmone.presentation.question.QuestionRegisterDto.QuestionRegisterResponse
import org.springframework.stereotype.Service

@Service
class QuestionRegisterService(

) {

    suspend fun registerQuestion(request: QuestionRegisterRequest): QuestionRegisterResponse {

        return QuestionRegisterResponse()
    }
}