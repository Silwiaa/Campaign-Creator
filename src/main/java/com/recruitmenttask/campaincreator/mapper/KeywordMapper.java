package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.Keyword;
import com.recruitmenttask.campaincreator.domain.KeywordDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class KeywordMapper {
    public KeywordDto mapToKeywordDto(Keyword keyword) {
        return KeywordDto.builder()
                .keywordId(keyword.getKeywordId())
                .name(keyword.getName())
                .campaignIds(keyword.getCampaigns().stream().map(Campaign::getCampaignId).collect(Collectors.toList()))
                .active(keyword.isActive())
                .build();
    }
}
