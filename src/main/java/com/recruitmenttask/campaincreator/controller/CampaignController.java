package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.controller.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.mapper.CampaignMapper;
import com.recruitmenttask.campaincreator.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/campaign")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignMapper campaignMapper;
    private final CampaignService campaignService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createCampaign")
    public ResponseEntity<Void> createCampaign(@RequestBody CampaignDto campaignDto) {
        Campaign campaign = campaignMapper.mapToCampain(campaignDto);
        campaignService.saveCampaign(campaign);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/updateBooking")
    public ResponseEntity<CampaignDto> updateCampaign(@RequestBody CampaignDto campaignDto) throws CampaignNotFoundException {
        Campaign campaign = campaignService.updateCampaign(campaignMapper.mapToCampain(campaignDto));
        return ResponseEntity.ok(campaignMapper.mapToCampainDto(campaign));
    }
}
