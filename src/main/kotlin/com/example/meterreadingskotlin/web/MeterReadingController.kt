package com.example.meterreadingskotlin.web

import com.example.meterreadingskotlin.service.MeterReadingService
import com.example.meterreadingskotlin.service.dto.MeterReadingDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MeterReadingController(private val meterReadingService: MeterReadingService)  {


    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        const val ENTITY_NAME = "meter-reading"
    }


    @GetMapping("/meter-readings")
    fun getAllMeterReadings(): MutableList<MeterReadingDTO> {
        log.debug("REST request to get all MeterReadings")
        return meterReadingService.findAll()
    }

    @PostMapping("/meter-readings")
    fun saveNewMeterReadings(@RequestBody meterReadingDTO: MeterReadingDTO): MeterReadingDTO {
        log.debug("REST request to save new MeterReading")
        return meterReadingService.save(meterReadingDTO)
    }

    @PutMapping("/meter-readings/{id}")
    fun updateMeterReading(
        @PathVariable(value = "id", required = false) id: Long,
        @RequestBody meterReadingDTO: MeterReadingDTO
    ): ResponseEntity<MeterReadingDTO> {
        log.debug("REST request to update MeterReading : {}, {}", id, meterReadingDTO)

        val result = meterReadingService.save(meterReadingDTO)
        return ResponseEntity.ok().body(result)
    }

    @DeleteMapping("/meter-readings/{id}")
    fun deleteMeterReading(@PathVariable id: Long): ResponseEntity<Void> {
        log.debug("REST request to delete MeterReading : $id")

        meterReadingService.delete(id)
        return ResponseEntity.ok().build()
    }

}
