package com.dillian.energymanagement.services

import com.dillian.energymanagement.dtos.BuildingRequestDTO
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class BuildingRequestsConverter : AttributeConverter<List<BuildingRequestDTO>, String> {
    private val objectMapper = jacksonObjectMapper()

    override fun convertToDatabaseColumn(requests: List<BuildingRequestDTO>?): String? {
        return requests?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(json: String?): List<BuildingRequestDTO>? {
        return json?.let { objectMapper.readValue(it) }
    }
}
