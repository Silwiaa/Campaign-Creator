package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Emerald;
import com.recruitmenttask.campaincreator.domain.EmeraldDto;
import org.springframework.stereotype.Service;

@Service
public class EmeraldMapper {
public EmeraldDto mapToEmeraldDto(Emerald emerald) {
        return EmeraldDto.builder()
                .emeraldId(emerald.getEmeraldId())
                .balance(emerald.getBalance())
                .build();
    }
}