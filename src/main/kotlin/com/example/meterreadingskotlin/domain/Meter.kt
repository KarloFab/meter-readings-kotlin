package com.example.meterreadingskotlin.domain

import javax.persistence.*


@Entity
@Table(name = "meter")
data class Meter(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var date: String? = null
)
