package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampaignService {
    public final CampaignRepository campaignRepository;

    public void saveCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Campaign campaign) {
        if(!campaignRepository.existsById(campaign.getCampaignId())) {
            throw new CampaignNotFoundException();
        }
        saveCampaign(campaign);
    }
}
