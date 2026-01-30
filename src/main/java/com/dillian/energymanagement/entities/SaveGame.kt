package com.dillian.energymanagement.entities

import com.dillian.energymanagement.dtos.BuildingRequestDTO
import com.dillian.energymanagement.dtos.District
import com.dillian.energymanagement.dtos.Tile
import com.dillian.energymanagement.services.*
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "save_games")
data class SaveGame(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val supervisorInstanceId: Long = 0,
    val savedAt: LocalDateTime = LocalDateTime.now(),

    @Column(columnDefinition = "TEXT")
    @Convert(converter = TilesConverter::class)
    var tiles: List<Tile> = mutableListOf(),

    @Column(columnDefinition = "TEXT")
    @Convert(converter = DistrictsConverter::class)
    var districts: List<District> = mutableListOf(),

    @Column(columnDefinition = "TEXT")
    @Convert(converter = BuildingRequestsConverter::class)
    var buildingRequests: List<BuildingRequestDTO> = mutableListOf(),

    var funds: Int = 0,
    var popularity: Int = 0,
    var research: Int = 0,
    var environmentalScore: Int = 0
)