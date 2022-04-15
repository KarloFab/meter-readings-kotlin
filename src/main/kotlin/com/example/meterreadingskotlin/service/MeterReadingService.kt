package com.example.meterreadingskotlin.service

import com.example.meterreadingskotlin.service.dto.MeterDTO
import com.example.meterreadingskotlin.service.dto.MeterReadingDTO
import java.util.*

interface MeterReadingService {
    fun save(meterReadingDTO: MeterReadingDTO): MeterReadingDTO

    fun partialUpdate(meterReadingDTO: MeterReadingDTO): Optional<MeterReadingDTO>

    fun findAll(): MutableList<MeterReadingDTO>

    fun findOne(id: Long): Optional<MeterReadingDTO>

    fun delete(id: Long)
}
