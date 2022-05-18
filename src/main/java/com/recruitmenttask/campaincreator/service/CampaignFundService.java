package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.domain.CampaignFund;
import com.recruitmenttask.campaincreator.exception.FundNotFoundException;
import com.recruitmenttask.campaincreator.repository.CampaignFundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampaignFundService {
    private final CampaignFundRepository campaignFundRepository;

    public CampaignFund findCampaignFundById(Long fundId) throws FundNotFoundException {
        return campaignFundRepository.findById(fundId).orElseThrow(FundNotFoundException::new);
    }
}
