package com.fone.filmone.domain.job_opening.service

import com.fone.filmone.common.exception.NotFoundUserException
import com.fone.filmone.infrastructure.job_opening.JobOpeningRepository
import com.fone.filmone.infrastructure.user.UserRepository
import com.fone.filmone.presentation.job_opening.RegisterJobOpeningDto
import com.fone.filmone.presentation.job_opening.RegisterJobOpeningDto.RegisterJobOpeningResponse
import org.springframework.stereotype.Service

@Service
class RegisterJobOpeningService(
    private val jobOpeningRepository: JobOpeningRepository,
    private val userRepository: UserRepository,
) {

    suspend fun registerJobOpening(
        request: RegisterJobOpeningDto.RegisterJobOpeningRequest,
        email: String
    ): RegisterJobOpeningResponse {
        val user = userRepository.findByEmail(email) ?: throw NotFoundUserException()

        with(request) {
            val jobOpening = toEntity(user.id!!)

            jobOpeningRepository.save(jobOpening)

            return RegisterJobOpeningResponse(jobOpening)
        }
    }
}