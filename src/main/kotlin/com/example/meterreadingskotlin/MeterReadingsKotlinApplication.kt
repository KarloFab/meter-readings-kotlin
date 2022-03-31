package com.example.meterreadingskotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
class MeterReadingsKotlinApplication

fun main(args: Array<String>) {
    runApplication<MeterReadingsKotlinApplication>(*args)
}
