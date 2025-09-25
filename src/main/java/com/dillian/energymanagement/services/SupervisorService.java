package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.SupervisorDTO;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final SupervisorMapper supervisorMapper;

    public SupervisorDTO create(SupervisorDTO supervisorDTO) {
        Supervisor supervisor = supervisorMapper.toEntity(supervisorDTO);
        supervisor = supervisorRepository.save(supervisor);
        return supervisorMapper.toDto(supervisor);
    }

    public SupervisorDTO findById(Long id) {
        log.info("passed id: " + id);
        Supervisor supervisor = supervisorRepository.findById(id).orElseThrow(RuntimeException::new);
        return supervisorMapper.toDto(supervisor);
    }

    public List<Supervisor> findAll() {
        return supervisorRepository.findAll();
    }

    public SupervisorDTO update(Long id, SupervisorDTO supervisorDTO) {
        Supervisor supervisor = supervisorRepository.findById(id).orElseThrow(RuntimeException::new);
        supervisor = supervisorMapper.toEntity(supervisorDTO);
        supervisor = supervisorRepository.save(supervisor);
        return supervisorMapper.toDto(supervisor);
    }
}
