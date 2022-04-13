package com.example.meterreadingskotlin.web

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
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@WithMockUser(username="guest", password = "guestPasswd")
@AutoConfigureMockMvc
class MeterControllerTest( @Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var meterService: MeterService

    @Test
    fun getAllMeters() {
        val meterDto =  MeterDTO(1, "Test name")
        every { meterService.findAll() } returns mutableListOf(meterDto)
        // Get all the meters
        mockMvc.perform(MockMvcRequestBuilders.get("/api/meters").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").value(Matchers.hasItem(meterDto.id?.toInt())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").value(Matchers.hasItem(meterDto.name.toString())))
    }

    @Test
    fun saveNewMeter() {
        val meterDto = MeterDTO()
        meterDto.name = "Test name"

        val savedMeterDto = MeterDTO(1, "Test name")

        every { meterService.save(meterDto) } returns (savedMeterDto)

        mockMvc.perform(MockMvcRequestBuilders.post("/api/meters").contentType(MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonBytes(meterDto)))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value((savedMeterDto.id?.toInt())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value((savedMeterDto.name.toString())))
    }

    @Test
    fun updateMeter() {
        val meterId = 1L

        val meter = MeterDTO(meterId, "Updated name")

        every { meterService.save(meter) } returns (meter)


        mockMvc.perform(MockMvcRequestBuilders.put("/api/meters/$meterId").contentType(MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonBytes(meter)))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value((meter.id?.toInt())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value((meter.name.toString())))
    }

    @Test
    fun deleteMeter() {
        val meterId = 1L

        every { meterService.delete(meterId) } returns Unit

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/meters/$meterId")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}
