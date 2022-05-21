package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.domain.Keyword;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.exception.KeywordNotFoundException;
import com.recruitmenttask.campaincreator.repository.KeywordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;
    private final CampaignService campaignService;

    private void saveKeyword(Keyword keyword) {
        keywordRepository.save(keyword);
    }

    public void createKeyword(String name) {
        Keyword keyword = Keyword.builder()
                .name(name)
                .campaigns(new ArrayList<>())
                .active(true)
                .build();
        saveKeyword(keyword);
    }

    public Keyword findKeywordById(Long keywordId) throws KeywordNotFoundException {
        return keywordRepository.findById(keywordId).orElseThrow(KeywordNotFoundException::new);
    }

    public Keyword updateKeyword(Long keywordId, Long campaignId) throws KeywordNotFoundException, CampaignNotFoundException {
        Keyword keyword = findKeywordById(keywordId);
        Campaign campaign = campaignService.findCampaignById(campaignId);
        keyword.getCampaigns().add(campaign);
        saveKeyword(keyword);
        return keyword;
    }

    public List<Keyword> findKeywordsById(List<Long> keywordId) throws KeywordNotFoundException {
        List<Keyword> keywords = new ArrayList<>();
        for (Long id : keywordId) {
            keywords.add(findKeywordById(id));
        }
        return keywords;
    }
}
