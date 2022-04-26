package com.example.meterreadingskotlin.service.dto

import javax.validation.constraints.NotNull

data class MeterReadingDTO(
    var id: Long? = null,

    var name: String? = null,

    var electricityConsumption: Double? = null,

    @field:NotNull
    var meterId: Long
)
