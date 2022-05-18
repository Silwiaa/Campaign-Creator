package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.controller.exception.CampaignNotFoundException;
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

    public Campaign updateCampaign(Campaign campaign) throws CampaignNotFoundException {
        if(!campaignRepository.existsById(campaign.getCampaignId())) {
            throw new CampaignNotFoundException();
        }
        saveCampaign(campaign);
        return campaign;
    }

    public void deleteCampaign(Long campaignId) throws CampaignNotFoundException {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(CampaignNotFoundException::new);
        campaignRepository.delete(campaign);
    }
}
