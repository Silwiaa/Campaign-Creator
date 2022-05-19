package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class CampaignDto {
    private Long campaignId;
    private String name;
    private List<Long> keywordIds;
    private BigDecimal bidAmount;
    private BigDecimal campaignFound;
    private Status status;
    private String town;
    private BigDecimal radius;
    private Long emeraldId;
    private boolean enable;
}
