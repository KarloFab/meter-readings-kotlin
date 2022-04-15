package com.example.meterreadingskotlin.service.dto

data class MeterReadingDTO(
    var id: Long? = null,

    var name: String? = null,

    var electricityConsumption: Double? = null,
)
