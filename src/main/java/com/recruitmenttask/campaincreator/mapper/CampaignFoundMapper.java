package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.CampaignFund;
import com.recruitmenttask.campaincreator.domain.CampaignFundDto;
import com.recruitmenttask.campaincreator.exceptiond.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CampaignFoundMapper {
    private final CampaignService campaignService;

    public CampaignFund mapToCampaignFund(CampaignFundDto campaignFundDto) throws CampaignNotFoundException {
        return CampaignFund.builder()
                .foundId(campaignFundDto.getFoundId())
                .campaign(campaignService.findCampaignByID(campaignFundDto.getCampaignId()))
                .build();
    }
}