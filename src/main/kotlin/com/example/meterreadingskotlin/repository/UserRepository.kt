package com.example.meterreadingskotlin.repository

import com.example.meterreadingskotlin.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Any?, Any?> {
    fun findByUsername(username: String?): User?
}

