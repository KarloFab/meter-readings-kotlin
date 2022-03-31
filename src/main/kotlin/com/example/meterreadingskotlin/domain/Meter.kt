package com.example.meterreadingskotlin.domain

import javax.persistence.*


@Entity
@Table(name = "meter")
data class Meter (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String? = null
)
