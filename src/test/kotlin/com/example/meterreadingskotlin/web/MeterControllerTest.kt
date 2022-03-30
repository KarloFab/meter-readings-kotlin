package com.example.meterreadingskotlin.web

import com.example.meterreadingskotlin.MeterReadingsKotlinApplication
import com.example.meterreadingskotlin.repository.MeterRepository
import com.example.meterreadingskotlin.service.MeterService
import com.example.meterreadingskotlin.service.dto.MeterDTO
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@AutoConfigureMockMvc
@SpringBootTest(classes = [MeterReadingsKotlinApplication::class])
class MeterControllerTest( @Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var meterService: MeterService

    @Test
    fun `get all meters`() {
        val meterDto =  MeterDTO(1, "Test name")
        every { meterService.findAll() } returns mutableListOf(meterDto)
        // Get all the meters
        mockMvc.perform(MockMvcRequestBuilders.get("/api/meters").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").value(Matchers.hasItem(meterDto.id?.toInt())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").value(Matchers.hasItem(meterDto.name.toString())))
    }
}
