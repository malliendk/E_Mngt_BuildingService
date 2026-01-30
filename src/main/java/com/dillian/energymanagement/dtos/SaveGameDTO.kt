package com.dillian.energymanagement.dtos

import java.time.LocalDateTime

data class SaveGameDTO(

    val id: Long,
    var name: String,
    val supervisorInstanceId: Long = 0,
    val savedAt: LocalDateTime = LocalDateTime.now(),
    var tiles: List<Tile> = mutableListOf(),
    var districts: List<District> = mutableListOf(),
    var buildingRequests: List<BuildingRequestDTO> = mutableListOf(),
    var funds: Int = 0,
    var popularity: Int = 0,
    var research: Int = 0,
    var environmentalScore: Int = 0
)

