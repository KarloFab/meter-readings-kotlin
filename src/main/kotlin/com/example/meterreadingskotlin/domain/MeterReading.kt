package com.example.meterreadingskotlin.domain

import javax.persistence.*

@Entity
@Table(name = "meter_reading")
data class MeterReading(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String? = null,

    var electricityConsumption: Double? = null,

    @ManyToOne
    var meter: Meter
)
