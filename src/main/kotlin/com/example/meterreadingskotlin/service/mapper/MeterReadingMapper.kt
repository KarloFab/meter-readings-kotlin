package com.example.meterreadingskotlin.service.mapper

import com.example.meterreadingskotlin.domain.MeterReading
import com.example.meterreadingskotlin.service.dto.MeterReadingDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface MeterReadingMapper : EntityMapper<MeterReadingDTO, MeterReading>
