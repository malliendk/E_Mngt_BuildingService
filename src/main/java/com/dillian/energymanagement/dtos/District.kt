package com.dillian.energymanagement.dtos

data class District(

    val id: Long,
    val energyProduction: Int = 0,
    val energyConsumption: Int = 0,
    val excessBalance: Int = 0,
    val gridCapacity: Int = 0,
    val gridLoad: Double = 0.0,
    val incomingExcessBalances: List<Int>,
    val tiles: List<Tile>
)