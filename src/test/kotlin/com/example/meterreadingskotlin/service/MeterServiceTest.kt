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

    private val meterTestName = "Test name";

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun whenGetAllMeters_ThenReturnMeters() {
        val meter = Meter(1, meterTestName)
        val meterDTO = MeterDTO(1, meterTestName)

        //given
        every { meterRepository.findAll() } returns listOf(meter)
        every { meterMapper.toDto(meter) } returns meterDTO

        //when
        val result = meterServiceImpl.findAll()

        //then

        verify(exactly = 1) { meterRepository.findAll() }

        assertEquals(meterDTO.id, result[0].id)
        assertEquals(meterDTO.name, result[0].name)
    }

    @Test
    fun whenSaveNewMeter_thenReturnSavedMeter() {
        val meterDtoToSave = MeterDTO()
        meterDtoToSave.name = meterTestName

        val meterToSave = Meter()
        meterToSave.name = meterTestName

        val savedMeter = Meter(1, meterTestName)
        val meterDTO = MeterDTO(1, meterTestName)

        //given
        every { meterMapper.toEntity(meterDtoToSave) } returns meterToSave
        every { meterRepository.save(meterToSave) } returns savedMeter
        every { meterMapper.toDto(savedMeter) } returns meterDTO

        //when
        val result = meterServiceImpl.save(meterDtoToSave)

        //then
        verify(exactly = 1) { meterRepository.save(meterToSave) }

        assertEquals(meterDTO.id, result.id)
        assertEquals(meterDTO.name, result.name)
    }
}
