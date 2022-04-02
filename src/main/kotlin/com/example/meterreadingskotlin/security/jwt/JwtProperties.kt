package com.example.meterreadingskotlin.security.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtProperties {

    @Value("\${jwt.token.validity.in.seconds}")
    var tokenValidityInMilliseconds: Long = 0

    @Value("\${jwt.token.validity.in.seconds.for.remember.me}")
    var tokenValidityInMillisecondsForRememberMe: Long = 0

    @Value("\${jwt.base64.secret}")
    var base64Secret: String? = null

}
