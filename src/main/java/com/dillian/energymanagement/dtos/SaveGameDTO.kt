package com.dillian.energymanagement.dtos

import com.dillian.energymanagement.entities.BuildingInGame
import java.time.LocalDateTime

data class SaveGameDTO(

    val id: Long,
    var name: String,
    val supervisorInstanceId: Long = 0,
    var savedAt: LocalDateTime = LocalDateTime.now(),
    var tiles: List<Tile> = mutableListOf(),
    var buildings: List<BuildingInGame> = mutableListOf(),
    var funds: Int = 0,
    var popularity: Int = 0,
    var research: Int = 0,
    var environmentalScore: Int = 0
)

