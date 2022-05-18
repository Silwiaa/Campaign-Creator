package com.recruitmenttask.campaincreator.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name ="CAMPAIGNS")
public class Campaign {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAMPAIGN_ID")
    private Long campaignId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "KEYWORDS")
    private String keyword;

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
