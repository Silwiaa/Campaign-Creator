package com.recruitmenttask.campaincreator.domain;

import lombok.*;

import javax.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FUND_ID")
    private CampaignFund campaignFund;

    @NotNull
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "TOWN")
    private String town;

    @Column(name = "RADIUS")
    private BigDecimal radius;
}
