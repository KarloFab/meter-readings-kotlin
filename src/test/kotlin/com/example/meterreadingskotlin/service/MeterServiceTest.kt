package com.example.meterreadingskotlin.service

import com.example.meterreadingskotlin.domain.Meter
import com.example.meterreadingskotlin.repository.MeterRepository
import com.example.meterreadingskotlin.service.dto.MeterDTO
import com.example.meterreadingskotlin.service.impl.MeterServiceImpl
import com.example.meterreadingskotlin.service.mapper.MeterMapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MeterServiceTest {

    @MockK
    lateinit var meterRepository: MeterRepository

    @MockK
    lateinit var meterMapper: MeterMapper

    @InjectMockKs
    lateinit var meterServiceImpl: MeterServiceImpl

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun whenGetAllMeters_ThenReturnMeters() {
        val meter = Meter(1, "Test name")
        val meterDTO = MeterDTO(1, "Test name")

        //given
        every { meterRepository.findAll() } returns listOf(meter)
        every { meterMapper.toDto(meter) } returns meterDTO

        //when
        val result = meterServiceImpl.findAll();

        //then

        verify(exactly = 1) { meterRepository.findAll() }

        assertEquals(meterDTO.id, result[0].id)
        assertEquals(meterDTO.name, result[0].name)
    }
}
