package com.dillian.energymanagement.dtos

class BuildingRequestDTO(
    val buildingId: Long,
    val solarPanelAmount: Int,
    val energyProduction: Int,
    val goldIncome: Int,
    val popularityIncome: Int,
    val researchIncome: Int,
    val environmentalScore: Int
)