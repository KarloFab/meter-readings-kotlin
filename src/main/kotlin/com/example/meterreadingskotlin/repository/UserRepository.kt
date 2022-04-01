package com.example.meterreadingskotlin.repository

import com.example.meterreadingskotlin.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<Any?, Any?> {
    fun findByUsername(username: String?): Optional<User>
}

