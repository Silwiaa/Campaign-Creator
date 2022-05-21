package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.CampaignDto;
import com.recruitmenttask.campaincreator.domain.Keyword;
import com.recruitmenttask.campaincreator.domain.KeywordDto;
import com.recruitmenttask.campaincreator.exception.BidAmountNotValidException;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.exception.KeywordNotFoundException;
import com.recruitmenttask.campaincreator.mapper.KeywordMapper;
import com.recruitmenttask.campaincreator.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/keyword")
@RequiredArgsConstructor
public class KeywordController {
    private final KeywordService keywordService;
    private final KeywordMapper keywordMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createKeyword/{name}")
    public ResponseEntity<Void> createKeyword(@PathVariable String name) {
        keywordService.createKeyword(name);
        return ResponseEntity.ok().build();

    }

    @PutMapping(value = "/updateKeyword")
    public ResponseEntity<KeywordDto> updateKeyword(@RequestParam Long keywordId, @RequestParam Long campaignId) throws CampaignNotFoundException, KeywordNotFoundException {
        Keyword keyword = keywordService.updateKeyword(keywordId, campaignId);
        return ResponseEntity.ok(keywordMapper.mapToKeywordDto(keyword));
    }
}
