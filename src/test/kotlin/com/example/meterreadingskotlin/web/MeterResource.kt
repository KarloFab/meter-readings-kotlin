package com.example.meterreadingskotlin.web

import com.example.meterreadingskotlin.domain.Meter
import com.example.meterreadingskotlin.repository.MeterRepository
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class MeterResource(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var meterRepository: MeterRepository

    private lateinit var meter: Meter

    @BeforeEach
    fun initTest() {
        meter = Meter(1, "Test name")
    }


    @Test
    fun `get all meters`() {
        // Initialize the database
        meterRepository.saveAndFlush(meter)

        // Get all the meters
        mockMvc.perform(MockMvcRequestBuilders.get("/api/meters").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").value(Matchers.hasItem(meter.id?.toInt())))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").value(Matchers.hasItem(meter.name.toString())))
    }
}
