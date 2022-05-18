package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CampaignFundDto {
    private Long foundId;
    private Long campaignId;
}