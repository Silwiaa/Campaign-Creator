package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {
    public final CampaignRepository campaignRepository;

    public void saveCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Campaign campaign) throws CampaignNotFoundException {
        if(campaignRepository.existsById(campaign.getCampaignId())) {
            saveCampaign(campaign);
        }
        throw new CampaignNotFoundException();
    }

    public void deleteCampaign(Long campaignId) throws CampaignNotFoundException {
        Campaign campaign = findCampaignById(campaignId);
        campaign.setEnable(false);
        saveCampaign(campaign);
    }

    public List<Campaign> findALlCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign findCampaignById(Long campaignId) throws CampaignNotFoundException {
        return campaignRepository.findById(campaignId).orElseThrow(CampaignNotFoundException::new);
    }
}
