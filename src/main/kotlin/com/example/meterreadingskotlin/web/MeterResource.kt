package com.example.meterreadingskotlin.web

import com.example.meterreadingskotlin.service.MeterService
import com.example.meterreadingskotlin.service.dto.MeterDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MeterResource(private val meterService: MeterService) {

    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        const val ENTITY_NAME = "meter"
    }

    /**
     * `GET  /meters` : get all the meters.
     *
     * @return the [ResponseEntity] with status `200 (OK)` and the list of meters in body.
     */
    @GetMapping("/meters")
    fun getAllMeters(): MutableList<MeterDTO> {
        log.debug("REST request to get all Meters")
        return meterService.findAll()
    }
}
