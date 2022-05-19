package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class KeywordDto {
    private Long campaignId;
    private String name;
    private Campaign campaign;
    private boolean active;
}
