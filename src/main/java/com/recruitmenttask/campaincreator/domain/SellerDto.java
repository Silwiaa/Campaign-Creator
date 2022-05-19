package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class SellerDto {
    private Long sellerId;
    private String name;
    private Long emeraldId;
    private boolean active;
    private boolean enabled;
}
