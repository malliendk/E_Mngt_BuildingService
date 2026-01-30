package com.dillian.energymanagement.services

import com.dillian.energymanagement.dtos.District
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


@Converter
class DistrictsConverter : AttributeConverter<List<District>, String> {
    private val objectMapper = jacksonObjectMapper()

    override fun convertToDatabaseColumn(districts: List<District>?): String? {
        return districts?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(json: String?): List<District>? {
        return json?.let { objectMapper.readValue(it) }
    }
}
