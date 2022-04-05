package com.example.meterreadingskotlin.repository

import com.example.meterreadingskotlin.domain.Meter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class MeterRepositoryTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var meterRepository: MeterRepository

    @Test
    fun whenFindAll_thenReturnMeters() {
        val meter = Meter()
        meter.name = "Test"

        entityManager.persist(meter)
        entityManager.flush()

        val foundMeters = meterRepository.findAll()
        assertThat(meter == foundMeters[0])
    }

    @Test
    fun whenSaveMeter_thenReturnMeterWithId() {
        val meter = Meter()
        meter.name = "Test"

        val savedMeter = meterRepository.save(meter)

        assertThat(savedMeter.name == meter.name)
        assertThat(savedMeter.id).isNotNull
    }
}
