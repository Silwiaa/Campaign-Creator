package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class CampaignFundDto {
    private Long foundId;
    private BigDecimal fundValue;
}