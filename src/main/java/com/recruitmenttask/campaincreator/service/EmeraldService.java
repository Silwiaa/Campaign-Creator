package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.Emerald;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.exception.EmeraldNotFoundException;
import com.recruitmenttask.campaincreator.repository.EmeraldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class EmeraldService {
    private final EmeraldRepository emeraldRepository;
    private final CampaignService campaignService;

    public void saveEmerald(Emerald emerald) {
        emeraldRepository.save(emerald);
    }
    public Emerald findEmeraldById(Long emeraldId) throws EmeraldNotFoundException {
        return emeraldRepository.findById(emeraldId).orElseThrow(EmeraldNotFoundException::new);
    }

    public Emerald updateEmerald(Long emeraldId, double bidAmount, Long campaignId) throws EmeraldNotFoundException, CampaignNotFoundException {
        Emerald emerald = findEmeraldById(emeraldId);
        emerald.setBalance(emerald.getBalance().min(new BigDecimal(bidAmount)));
        if(campaignId != 0) {
            Campaign campaign = campaignService.findCampaignByID(campaignId);
            emerald.getCampaigns().add(campaign);
        }
        return emerald;
    }
}
