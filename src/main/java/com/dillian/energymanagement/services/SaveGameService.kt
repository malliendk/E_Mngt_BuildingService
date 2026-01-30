package com.dillian.energymanagement.services

import com.dillian.energymanagement.dtos.SaveGameDTO
import com.dillian.energymanagement.entities.SaveGame
import com.dillian.energymanagement.mappers.SaveGameMapper
import com.dillian.energymanagement.repositories.SaveGameRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class SaveGameService(
    private val saveGameRepository: SaveGameRepository,
    private val mapper: SaveGameMapper
) {

    @Transactional
    open fun save(dto: SaveGameDTO): SaveGameDTO {
        var saveGame = mapper.toEntity(dto);
        saveGame = saveGameRepository.save(saveGame);
        return mapper.toDto(saveGame);
    }

    @Transactional(readOnly = true)
    open fun load(id: Long): SaveGameDTO {
        val saveGame = saveGameRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Save game not found: $id") };
        return mapper.toDto(saveGame);
    }

    @Transactional(readOnly = true)
    open fun getAll(): List<SaveGameDTO> {
        val saveGames = saveGameRepository.findAll()
        return saveGames.map { mapper.toDto(it) }
    }

    @Transactional
    open fun delete(id: Long) {
        saveGameRepository.deleteById(id)
    }
}

