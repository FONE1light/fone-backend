package com.fone.filmone.infrastructure.user

import com.fone.filmone.domain.user.User
import com.fone.filmone.domain.user.enum.SocialLoginType
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<User, Long> {

    suspend fun findByEmailAndSocialLoginType(email: String, socialLoginType: String): User?
}