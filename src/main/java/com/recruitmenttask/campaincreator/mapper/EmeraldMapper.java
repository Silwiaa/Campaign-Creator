package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.Emerald;
import com.recruitmenttask.campaincreator.domain.EmeraldDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmeraldMapper {
public EmeraldDto mapToEmeraldDto(Emerald emerald) {
        return EmeraldDto.builder()
                .emeraldId(emerald.getEmeraldId())
                .balance(emerald.getBalance())
                .campaignIds(emerald.getCampaigns().stream().map(Campaign::getCampaignId).collect(Collectors.toList()))
                .build();
    }
}