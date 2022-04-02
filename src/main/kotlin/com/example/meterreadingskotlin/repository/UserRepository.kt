package com.example.meterreadingskotlin.repository

import com.example.meterreadingskotlin.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String?): Optional<User>
}

