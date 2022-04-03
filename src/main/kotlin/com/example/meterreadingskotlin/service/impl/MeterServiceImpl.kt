package com.example.meterreadingskotlin.service.impl

import com.example.meterreadingskotlin.repository.MeterRepository
import com.example.meterreadingskotlin.service.MeterService
import com.example.meterreadingskotlin.service.dto.MeterDTO
import com.example.meterreadingskotlin.service.mapper.MeterMapper
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class MeterServiceImpl(
    private val meterRepository: MeterRepository,
    private val meterMapper: MeterMapper
) : MeterService {

    private val log = LoggerFactory.getLogger(javaClass);

    override fun save(meterDto: MeterDTO): MeterDTO {
        log.debug("Request to save Meter: $meterDto")
        var meter = meterMapper.toEntity(meterDto)
        meter = meterRepository.save(meter)
        return meterMapper.toDto(meter)
    }

    override fun partialUpdate(meterDto: MeterDTO): Optional<MeterDTO> {
        log.debug("Request to partial update Meter: $meterDto")

        return meterRepository.findById(meterDto.id!!)
            .map {
                meterMapper.partialUpdate(it, meterDto)
                it
            }
            .map { meterRepository.save(it) }
            .map { meterMapper.toDto(it) }
    }

    @Cacheable("meters")
    override fun findAll(): MutableList<MeterDTO> {
        log.debug("Request to get all Meters")
        simulateSlowService();
        return meterRepository.findAll()
            .mapTo(mutableListOf(), meterMapper::toDto)
    }

    private fun simulateSlowService() {
        try {
            val time = 3000L
            Thread.sleep(time)
        } catch (e: InterruptedException) {
            throw IllegalStateException(e)
        }
    }

    override fun findOne(id: Long): Optional<MeterDTO> {
        log.debug("Request to get Meter by id: $id")
        return meterRepository.findById(id).map(meterMapper::toDto)
    }

    override fun delete(id: Long) {
        log.debug("Request to delete Meter by id : $id")
        meterRepository.deleteById(id)
    }
}
