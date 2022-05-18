package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.mapper.CampaignMapper;
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
    private final CampainService campainService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createCampaign")
    public ResponseEntity<Void> createCampaign(@RequestBody CampaignDto campaignDto) throws Exception {
        Campaign campaign = campaignMapper.mapToCampain(campaignDto);
        campainService.saveCampain(campaign);
        return ResponseEntity.ok().build();
    }

}
