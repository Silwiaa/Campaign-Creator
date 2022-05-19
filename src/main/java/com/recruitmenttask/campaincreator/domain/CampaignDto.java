package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class CampaignDto {
    private Long campaignId;
    private String name;
    private String keyword;
    private BigDecimal bidAmount;
    private BigDecimal campaignFound;
    private Status status;
    private String town;
    private BigDecimal radius;
}
