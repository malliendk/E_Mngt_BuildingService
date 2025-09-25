package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.SupervisorDTO;
import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.stereotype.Component;

@Component
public class SupervisorMapper {

    public SupervisorDTO toDto(Supervisor supervisor) {
        SupervisorDTO dto = new SupervisorDTO();
        dto.setId(supervisor.getId());
        dto.setName(supervisor.getName());
        dto.setImageUrl(supervisor.getImageUrl());
        dto.setBiography(supervisor.getBiography());
        dto.setClassType(supervisor.getClassType());
        dto.setType(supervisor.getType());
        dto.setSpecialAbility(supervisor.getSpecialAbility());
        dto.setPerkGoldIncome(supervisor.getPerkGoldIncome());
        dto.setPerkGoldIncome(supervisor.getPerkGoldIncome());
        dto.setPerkPopularityIncome(supervisor.getPerkPopularityIncome());
        dto.setPerkPopularityCost(supervisor.getPerkPopularityCost());
        dto.setPerkResearchIncome(supervisor.getPerkResearchIncome());
        dto.setPerkResearchCost(supervisor.getPerkResearchCost());
        dto.setPerkGridEfficiency(supervisor.getPerkGridEfficiency());
        dto.setPerkGridResilience(supervisor.getPerkGridResilience());
        return dto;
    }

    public Supervisor toEntity(SupervisorDTO dto) {
        Supervisor supervisor = new Supervisor();
        supervisor.setId(dto.getId());
        supervisor.setName(dto.getName());
        supervisor.setImageUrl(dto.getImageUrl());
        supervisor.setBiography(dto.getBiography());
        supervisor.setClassType(dto.getClassType());
        supervisor.setType(dto.getType());
        supervisor.setSpecialAbility(dto.getSpecialAbility());
        supervisor.setPerkGoldIncome(dto.getPerkGoldIncome());
        supervisor.setPerkGoldCost(dto.getPerkGoldCost());
        supervisor.setPerkResearchCost(dto.getPerkResearchCost());
        supervisor.setPerkPopularityIncome(dto.getPerkPopularityIncome());
        supervisor.setPerkResearchIncome(dto.getPerkResearchIncome());
        supervisor.setPerkResearchCost(dto.getPerkGridEfficiency());
        supervisor.setPerkGridResilience(dto.getPerkGridResilience());
        return supervisor;
    }
}
