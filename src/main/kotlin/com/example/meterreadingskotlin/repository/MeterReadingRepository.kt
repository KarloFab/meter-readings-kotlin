package com.example.meterreadingskotlin.repository

import com.example.meterreadingskotlin.domain.MeterReading
import org.springframework.data.jpa.repository.JpaRepository

interface MeterReadingRepository: JpaRepository<MeterReading, Long>
