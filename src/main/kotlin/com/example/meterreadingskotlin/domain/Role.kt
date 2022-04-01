package com.example.meterreadingskotlin.domain

import com.example.meterreadingskotlin.domain.enums.RoleName
import javax.persistence.*


@Entity
@Table(name = "role")
data class Role (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @Enumerated(EnumType.STRING)
    var name: RoleName? = null

)
