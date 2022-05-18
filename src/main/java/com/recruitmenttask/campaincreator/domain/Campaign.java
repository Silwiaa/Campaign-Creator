package com.recruitmenttask.campaincreator.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name ="CAMPAIGNS")
public class Campaign {
    @Id
    @NotNull
    @Column(name = "CAMPAIGN_ID")
    private Long campaignId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "BID_AMOUNT")
    private BigDecimal bidAmount;

    @NotNull
    @Column(name = "CAMPAIGN_FOUND")
    private String campaignFound;

    @NotNull
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "TOWN")
    private String town;

    @Column(name = "RADIUS")
    private BigDecimal radius;
}
