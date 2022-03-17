package com.example.meterreadingskotlin.repository

import com.example.meterreadingskotlin.domain.Meter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MeterRepository : JpaRepository<Meter, Long>
