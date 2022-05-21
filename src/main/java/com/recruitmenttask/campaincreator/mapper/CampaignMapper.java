package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.domain.Keyword;
import com.recruitmenttask.campaincreator.exception.EmeraldNotFoundException;
import com.recruitmenttask.campaincreator.exception.KeywordNotFoundException;
import com.recruitmenttask.campaincreator.service.EmeraldService;
import com.recruitmenttask.campaincreator.service.KeywordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CampaignMapper {
    private final KeywordService keywordService;
    private final EmeraldService emeraldService;

    public Campaign mapToCampain(CampaignDto campaignDto) throws EmeraldNotFoundException, KeywordNotFoundException {
        return Campaign.builder()
                .campaignId(campaignDto.getCampaignId())
                .name(campaignDto.getName())
                .keywords(keywordService.findKeywordsById(campaignDto.getKeywordIds()))
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
