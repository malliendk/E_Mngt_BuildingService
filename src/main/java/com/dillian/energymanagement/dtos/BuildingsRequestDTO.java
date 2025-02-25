package com.dillian.energymanagement.dtos;

import lombok.Getter;

import java.util.Map;

@Getter
public class BuildingsRequestDTO {

    Map<Long, Integer> buildingIdsSolarPanelAmountMap;
}
