package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.exception.BidAmountNotValidException;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.mapper.CampaignMapper;
import com.recruitmenttask.campaincreator.service.CampaignService;
import com.recruitmenttask.campaincreator.validator.CampaignValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/campaign")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignMapper campaignMapper;
    private final CampaignService campaignService;
    private final CampaignValidator campaignValidator;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createCampaign")
    public ResponseEntity<Void> createCampaign(@RequestBody CampaignDto campaignDto) throws BidAmountNotValidException {
        campaignService.saveCampaign(campaignValidator.validateBidAmount(campaignMapper.mapToCampain(campaignDto)));
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/updateCampaign")
    public ResponseEntity<CampaignDto> updateCampaign(@RequestBody CampaignDto campaignDto) throws CampaignNotFoundException, BidAmountNotValidException {
        Campaign campaign = campaignService.updateCampaign(campaignValidator.validateBidAmount(campaignMapper.mapToCampain(campaignDto)));
        return ResponseEntity.ok(campaignMapper.mapToCampainDto(campaign));
    }

    @DeleteMapping(value = "/deleteCampaign/{taskId}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long campaignId) throws CampaignNotFoundException {
        campaignService.deleteCampaign(campaignId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getCampaigns")
    public ResponseEntity<List<CampaignDto>> getCampaigns() {
        List<Campaign> campaigns = campaignService.findALlCampaigns();
        return ResponseEntity.ok(campaignMapper.mapToCampainDtoList(campaigns));
    }

    @GetMapping(value = "/getCampaign/{campaignId}")
    public ResponseEntity<CampaignDto> getCampaign(@PathVariable Long campaignId) throws CampaignNotFoundException {
        return ResponseEntity.ok(campaignMapper.mapToCampainDto(campaignService.findCampaignByID(campaignId)));
    }
}
