package com.example.meterreadingskotlin.service.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LoginDTO (
    @field:NotNull
    @field:Size(min = 1, max = 50)
    var username: String? = null,

    @field:NotNull
    @field:Size(min = 4, max = 100)
    var password: String? = null,

    var isRememberMe: Boolean? = null
)
