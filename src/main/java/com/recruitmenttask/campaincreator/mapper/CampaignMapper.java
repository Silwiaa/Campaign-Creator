package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.domain.Keyword;
import com.recruitmenttask.campaincreator.exception.EmeraldNotFoundException;
import com.recruitmenttask.campaincreator.service.EmeraldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CampaignMapper {
    private final CampaignMapper campaignMapper;
    private final EmeraldService emeraldService;

    public Campaign mapToCampain(CampaignDto campaignDto) throws EmeraldNotFoundException {
        return Campaign.builder()
                .campaignId(campaignDto.getCampaignId())
                .name(campaignDto.getName())
                .keywords(campaignMapper.mapToCampain(campaignDto).getKeywords())
                .bidAmount(campaignDto.getBidAmount())
                .campaignFund(campaignDto.getCampaignFound())
                .status(campaignDto.getStatus())
                .town(campaignDto.getTown())
                .radius(campaignDto.getRadius())
                .emerald(emeraldService.findEmeraldById(campaignDto.getEmeraldId()))
                .enable(campaignDto.isEnable())
                .build();
    }

    public CampaignDto mapToCampainDto(Campaign campaign) {
        return CampaignDto.builder()
                .campaignId(campaign.getCampaignId())
                .name(campaign.getName())
                .keywordIds(campaign.getKeywords().stream().map(Keyword::getKeywordId).collect(Collectors.toList()))
                .bidAmount(campaign.getBidAmount())
                .campaignFound(campaign.getCampaignFund())
                .status(campaign.getStatus())
                .town(campaign.getTown())
                .radius(campaign.getRadius())
                .emeraldId(campaign.getEmerald().getEmeraldId())
                .build();
    }

    public List<CampaignDto> mapToCampainDtoList(List<Campaign> campaigns) {
        return campaigns.stream()
                .map(this::mapToCampainDto)
                .collect(Collectors.toList());
    }
}
