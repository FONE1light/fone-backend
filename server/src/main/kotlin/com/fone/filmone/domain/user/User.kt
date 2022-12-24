package com.fone.filmone.domain.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table("users")
data class User(

    @Id
    val id: Long? = null,

    @Column
    val job: String,

    @Column
    val interests: String,

    @Column
    val nickname: String,

    @Column
    val birthday: String,

    @Column
    val gender: String,

    @Column
    val profileUrl: String,

    @Column
    val phoneNumber: String,

    @Column
    val email: String,

    @Column
    val providerType: String,
)

