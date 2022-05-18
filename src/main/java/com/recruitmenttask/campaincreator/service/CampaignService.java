package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.exceptiond.CampaignNotFoundException;
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
        if(!campaignRepository.existsById(campaign.getCampaignId())) {
            throw new CampaignNotFoundException();
        }
        saveCampaign(campaign);
        return campaign;
    }

    public void deleteCampaign(Long campaignId) throws CampaignNotFoundException {
        Campaign campaign = findCampaignByID(campaignId);
        campaignRepository.delete(campaign);
    }

    public List<Campaign> findALlCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign findCampaignByID(Long campaignId) throws CampaignNotFoundException {
        return campaignRepository.findById(campaignId).orElseThrow(CampaignNotFoundException::new);
    }
}
