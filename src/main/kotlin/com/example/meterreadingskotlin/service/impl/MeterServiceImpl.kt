package com.example.meterreadingskotlin.service.impl

import com.example.meterreadingskotlin.domain.Meter
import com.example.meterreadingskotlin.repository.MeterRepository
import com.example.meterreadingskotlin.service.MeterService
import com.example.meterreadingskotlin.service.dto.MeterDTO
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class MeterServiceImpl(
    private val meterRepository: MeterRepository
): MeterService {

    private val log = LoggerFactory.getLogger(javaClass);

    override fun save(meterDto: MeterDTO): MeterDTO {
        log.debug("Request to save Meter: $meterDto")
        TODO("Not yet implemented")
    }

    override fun partialUpdate(meterDto: MeterDTO): Optional<MeterDTO> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<MeterDTO> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: Long): Optional<MeterDTO> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}
