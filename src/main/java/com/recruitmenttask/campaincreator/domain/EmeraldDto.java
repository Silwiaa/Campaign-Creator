package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class EmeraldDto {
    private Long emeraldId;
    private BigDecimal balance;
    private List<Long> campaignIds;
}