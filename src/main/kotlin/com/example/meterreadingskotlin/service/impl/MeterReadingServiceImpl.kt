package com.example.meterreadingskotlin.service.impl

import com.example.meterreadingskotlin.repository.MeterReadingRepository
import com.example.meterreadingskotlin.repository.MeterRepository
import com.example.meterreadingskotlin.service.MeterReadingService
import com.example.meterreadingskotlin.service.dto.MeterReadingDTO
import com.example.meterreadingskotlin.service.mapper.MeterMapper
import com.example.meterreadingskotlin.service.mapper.MeterReadingMapper
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class MeterReadingServiceImpl(
    private val meterReadingRepository: MeterReadingRepository,
    private val meterReadingMapper: MeterReadingMapper
) : MeterReadingService {
    override fun save(meterReadingDTO: MeterReadingDTO): MeterReadingDTO {
        TODO("Not yet implemented")
    }

    override fun partialUpdate(meterReadingDTO: MeterReadingDTO): Optional<MeterReadingDTO> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<MeterReadingDTO> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: Long): Optional<MeterReadingDTO> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

}

