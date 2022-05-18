package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import org.springframework.stereotype.Service;

@Service
public class CampaignMapper {
    public Campaign mapToCampain(CampaignDto campaignDto) {
        return Campaign.builder()
                .campaignId(campaignDto.getCampaignId())
                .name(campaignDto.getName())
                .keyword(campaignDto.getKeyword())
                .bidAmount(campaignDto.getBidAmount())
                .campaignFound(campaignDto.getCampaignFound())
                .status(campaignDto.getStatus())
                .town(campaignDto.getTown())
                .radius(campaignDto.getRadius())
                .build();
    }

    public CampaignDto mapToCampainDto(Campaign campaign) {
        return CampaignDto.builder()
                .campaignId(campaign.getCampaignId())
                .name(campaign.getName())
                .keyword(campaign.getKeyword())
                .bidAmount(campaign.getBidAmount())
                .campaignFound(campaign.getCampaignFound())
                .status(campaign.getStatus())
                .town(campaign.getTown())
                .radius(campaign.getRadius())
                .build();
    }
}
