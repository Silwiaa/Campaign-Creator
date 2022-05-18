package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class CampaignDto {
    private Long campaignId;
    private String name;
    private BigDecimal bidAmount;
    private String campaignFound;
    private Status status;
    private String town;
    private BigDecimal radius;
}
