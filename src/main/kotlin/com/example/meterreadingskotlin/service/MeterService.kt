package com.example.meterreadingskotlin.service

import com.example.meterreadingskotlin.service.dto.MeterDTO
import java.util.*


interface MeterService {

    fun save(meter: MeterDTO): MeterDTO

    fun partialUpdate(meter: MeterDTO): Optional<MeterDTO>

    fun findAll(): MutableList<MeterDTO>

    fun findOne(id: Long): Optional<MeterDTO>

    fun delete(id: Long)
}
