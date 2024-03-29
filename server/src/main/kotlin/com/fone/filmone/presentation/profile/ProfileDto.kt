package com.fone.filmone.presentation.profile

import com.fone.filmone.domain.common.Career
import com.fone.filmone.domain.common.Domain
import com.fone.filmone.domain.common.Gender
import com.fone.filmone.domain.common.Interest
import com.fone.filmone.domain.profile.entity.Profile

data class ProfileDto(
    val hookingComment: String,
    val birthday: String,
    val gender: Gender,
    val height: Int,
    val weight: Int,
    val email: String,
    val sns: String,
    val specialty: String,
    val details: String,
    val career: Career,
    val interests: List<Interest>,
    val domains: List<Domain>,
    val profileImages: List<String>,
    val viewCount: Long,
) {
    constructor(profile: Profile) : this(
        hookingComment = profile.hookingComment,
        birthday = profile.birthday,
        gender = profile.gender,
        height = profile.height,
        weight = profile.weight,
        email = profile.email,
        sns = profile.sns,
        specialty = profile.specialty,
        details = profile.details,
        career = profile.career,
        interests = profile.interests.split(",").map { Interest(it) }.toList(),
        domains = profile.domains.split(",").map { Domain(it) }.toList(),
        profileImages = listOf(),
        viewCount = profile.viewCount,
    )
}