package com.dillian.energymanagement.controllers

import com.dillian.energymanagement.config.log
import com.dillian.energymanagement.dtos.SaveGameDTO
import com.dillian.energymanagement.entities.SaveGame
import com.dillian.energymanagement.mappers.SaveGameMapper
import com.dillian.energymanagement.services.SaveGameService
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestClient


@RestController
@RequestMapping("save-game/")
class SaveGameController(
    private val saveGameService: SaveGameService,
    private val restClient: RestClient
) {

    @PostMapping("save")
    fun save(@RequestBody saveGameDTO: SaveGameDTO) {
        log.info("Saving Game ${saveGameDTO.id}")
        val newDto = saveGameService.save(saveGameDTO)
        ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newDto)
    }

    @GetMapping("load/{id}")
    fun load(@PathVariable("id") id: Long) {
        log.info("Loading game with id: {}", id)
        val loadedGame = saveGameService.load(id)
        log.info("Successfully loaded game. Now sending to calculation service")
        restClient.post()
            .uri("save")
            .body(loadedGame)
            .accept()
        ResponseEntity.status(HttpStatus.OK)
    }
}