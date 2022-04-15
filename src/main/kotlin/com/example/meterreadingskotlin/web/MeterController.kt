package com.example.meterreadingskotlin.web

import com.example.meterreadingskotlin.service.MeterService
import com.example.meterreadingskotlin.service.dto.MeterDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MeterController(private val meterService: MeterService) {

    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        const val ENTITY_NAME = "meter"
    }


    @GetMapping("/meters")
    fun getAllMeters(): MutableList<MeterDTO> {
        log.debug("REST request to get all Meters")
        return meterService.findAll()
    }

    @PostMapping("/meters")
    fun saveNewMeter(@RequestBody meterDTO: MeterDTO): MeterDTO {
        log.debug("REST request to save new meter")
        return meterService.save(meterDTO)
    }

    @PutMapping("/meters/{id}")
    fun updateMeter(
        @PathVariable(value = "id", required = false) id: Long,
        @RequestBody meterDTO: MeterDTO
    ): ResponseEntity<MeterDTO> {
        log.debug("REST request to update Meter : {}, {}", id, meterDTO)

        val result = meterService.save(meterDTO)
        return ResponseEntity.ok().body(result)
    }

    @DeleteMapping("/meters/{id}")
    fun deleteMeter(@PathVariable id: Long): ResponseEntity<Void> {
        log.debug("REST request to delete meter : $id")

        meterService.delete(id)
        return ResponseEntity.ok().build()
    }
}
