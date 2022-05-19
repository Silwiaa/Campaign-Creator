package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.domain.Emerald;
import com.recruitmenttask.campaincreator.domain.EmeraldDto;
import com.recruitmenttask.campaincreator.exception.BidAmountNotValidException;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.exception.EmeraldNotFoundException;
import com.recruitmenttask.campaincreator.mapper.EmeraldMapper;
import com.recruitmenttask.campaincreator.service.EmeraldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/emerald")
@RequiredArgsConstructor
public class EmeraldController {
    private final EmeraldMapper emeraldMapper;
    private final EmeraldService emeraldService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createEmerald")
    public ResponseEntity<Void> createEmerald() {
        emeraldService.createEmerald();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getEmerald/{emeraldId}")
    public ResponseEntity<EmeraldDto> getEmerald(@PathVariable Long emeraldId) throws EmeraldNotFoundException {
        return ResponseEntity.ok(emeraldMapper.mapToEmeraldDto(emeraldService.findEmeraldById(emeraldId)));
    }

    @PutMapping(value = "/updateBalance")
    public ResponseEntity<EmeraldDto> updateBalance(@RequestParam Long emeraldId, @RequestParam double bidAmount) throws EmeraldNotFoundException {
        Emerald emerald = emeraldService.updateBalance(emeraldId, bidAmount);
        return ResponseEntity.ok(emeraldMapper.mapToEmeraldDto(emerald));
    }

    @PutMapping(value = "/updateCampaigns")
    public ResponseEntity<EmeraldDto> updateCampaigns(@RequestParam Long emeraldId, @RequestParam Long campaignId) throws EmeraldNotFoundException, CampaignNotFoundException {
        Emerald emerald = emeraldService.updateCampaigns(emeraldId, campaignId);
        return ResponseEntity.ok(emeraldMapper.mapToEmeraldDto(emerald));
    }
}
