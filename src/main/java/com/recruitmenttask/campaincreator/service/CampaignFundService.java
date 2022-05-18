package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.domain.CampaignFund;
import com.recruitmenttask.campaincreator.exception.FundNotFoundException;
import com.recruitmenttask.campaincreator.repository.CampaignFundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CampaignFundService {
    private final CampaignFundRepository campaignFundRepository;

    public CampaignFund findCampaignFundById(Long fundId) throws FundNotFoundException {
        return campaignFundRepository.findById(fundId).orElseThrow(FundNotFoundException::new);
    }

    public CampaignFund updateCampaignFund(Long fundId, BigDecimal bidAmount) throws FundNotFoundException {
        CampaignFund campaignFund = campaignFundRepository.findById(fundId).orElseThrow(FundNotFoundException::new);
        campaignFund.setCampaignFund(campaignFund.getCampaignFund().min(bidAmount));
        return campaignFund;
    }
}
