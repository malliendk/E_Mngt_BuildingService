package com.dillian.energymanagement.mappers

import com.dillian.energymanagement.dtos.SaveGameDTO
import com.dillian.energymanagement.entities.SaveGame
import org.springframework.stereotype.Component

@Component
class SaveGameMapper {

    /**
     * Maps a SaveGame entity to a SaveGameDTO
     */
    fun toDto(entity: SaveGame): SaveGameDTO {
        return SaveGameDTO(
            id = entity.id ?: 0L,
            supervisorInstanceId = entity.supervisorInstanceId,
            savedAt = entity.savedAt,
            tiles = entity.tiles,
            districts = entity.districts,
            buildingRequests = entity.buildingRequests,
            funds = entity.funds,
            popularity = entity.popularity,
            research = entity.research,
            environmentalScore = entity.environmentalScore
        )
    }

    /**
     * Maps a SaveGameDTO to a SaveGame entity
     */
    fun toEntity(dto: SaveGameDTO): SaveGame {
        return SaveGame(
            id = if (dto.id == 0L) null else dto.id,
            supervisorInstanceId = dto.supervisorInstanceId,
            savedAt = dto.savedAt,
            tiles = dto.tiles,
            districts = dto.districts,
            buildingRequests = dto.buildingRequests,
            funds = dto.funds,
            popularity = dto.popularity,
            research = dto.research,
            environmentalScore = dto.environmentalScore
        )
    }
}