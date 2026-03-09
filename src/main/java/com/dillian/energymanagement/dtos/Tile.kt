package com.dillian.energymanagement.dtos

import com.dillian.energymanagement.entities.BuildingInGame

data class Tile(
    val id: Long,
    var building: BuildingInGame,
    var zoneType: String = "",
    var adjacencySet: AdjacencySet? = null,
    var hasPowerLine: Boolean = false
) {

}
