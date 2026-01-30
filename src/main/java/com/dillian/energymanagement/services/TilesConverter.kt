package com.dillian.energymanagement.services

import com.dillian.energymanagement.dtos.Tile
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class TilesConverter : AttributeConverter<List<Tile>, String> {
    private val objectMapper = jacksonObjectMapper()

    override fun convertToDatabaseColumn(tiles: List<Tile>?): String? {
        return tiles?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(json: String?): List<Tile>? {
        return json?.let { objectMapper.readValue(it) }
    }
}
