package com.example.meterreadingskotlin.service.impl

import com.example.meterreadingskotlin.repository.MeterReadingRepository
import com.example.meterreadingskotlin.repository.MeterRepository
import com.example.meterreadingskotlin.service.MeterReadingService
import com.example.meterreadingskotlin.service.dto.MeterReadingDTO
import com.example.meterreadingskotlin.service.mapper.MeterReadingMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class MeterReadingServiceImpl(
    private val meterReadingRepository: MeterReadingRepository,
    private val meterReadingMapper: MeterReadingMapper,
    private val meterRepository: MeterRepository
) : MeterReadingService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(meterReadingDTO: MeterReadingDTO): MeterReadingDTO {
        log.debug("Request to save MeterReading: $meterReadingDTO")
        var meterReading = meterReadingMapper.toEntity(meterReadingDTO)
        val meter = meterRepository.findById(meterReadingDTO.meterId)
        meterReading.meter = meter.get()
        meterReading = meterReadingRepository.save(meterReading)
        return meterReadingMapper.toDto(meterReading)
    }

    override fun partialUpdate(meterReadingDTO: MeterReadingDTO): Optional<MeterReadingDTO> {
        log.debug("Request to partial update MeterReading: $meterReadingDTO")

        return meterReadingRepository.findById(meterReadingDTO.id!!)
            .map {
                meterReadingMapper.partialUpdate(it, meterReadingDTO)
                it
            }
            .map { meterReadingRepository.save(it) }
            .map { meterReadingMapper.toDto(it) }
    }

    override fun findAll(): MutableList<MeterReadingDTO> {
        log.debug("Request to find all MeterReadings")
        return meterReadingRepository.findAll()
            .mapTo(mutableListOf(), meterReadingMapper::toDto)
    }

    override fun findOne(id: Long): Optional<MeterReadingDTO> {
        log.debug("Request to get MeterReading by id: $id")
        return meterReadingRepository.findById(id).map(meterReadingMapper::toDto)
    }

    override fun delete(id: Long) {
        log.debug("Request to delete MeterReading by id: $id")
        meterReadingRepository.deleteById(id)
    }

}

