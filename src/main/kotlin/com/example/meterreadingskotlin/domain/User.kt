package com.example.meterreadingskotlin.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @NotNull
    var username: String? = null,

    @NotNull
    var password: String? = null,

    var isEnabled: Boolean = false,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: List<Role>? = null
)
