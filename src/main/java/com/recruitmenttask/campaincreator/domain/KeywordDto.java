package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class KeywordDto {
    private Long keywordId;
    private String name;
    private List<Long> campaignIds;
    private boolean active;
}
