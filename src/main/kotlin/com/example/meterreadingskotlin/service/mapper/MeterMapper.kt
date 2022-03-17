package com.example.meterreadingskotlin.service.mapper

import com.example.meterreadingskotlin.domain.Meter
import com.example.meterreadingskotlin.service.dto.MeterDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface MeterMapper : EntityMapper<MeterDTO, Meter>
