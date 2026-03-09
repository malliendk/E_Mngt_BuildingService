package com.dillian.energymanagement.services

import com.dillian.energymanagement.entities.BuildingInGame
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class BuildingRequestsConverter : AttributeConverter<List<BuildingInGame>, String> {
    private val objectMapper = jacksonObjectMapper()

    override fun convertToDatabaseColumn(requests: List<BuildingInGame>?): String? {
        return requests?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(json: String?): List<BuildingInGame>? {
        return json?.let { objectMapper.readValue(it) }
    }
}
