package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.CampaignFund;
import com.recruitmenttask.campaincreator.domain.CampaignFundDto;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CampaignFundMapper {
public CampaignFundDto mapToCampaignFundDto(CampaignFund campaignFund) {
        return CampaignFundDto.builder()
                .foundId(campaignFund.getFoundId())
                .campaignId(campaignFund.getCampaign().getCampaignId())
                .build();
    }
}