package com.recruitmenttask.campaincreator.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "campaigns")
    public List<Keyword> keywords;

    @NotNull
    @Column(name = "BID_AMOUNT")
    private BigDecimal bidAmount;

    @NotNull
    @Column(name = "CAMPAIGN_FUND")
    private BigDecimal campaignFund;

    @NotNull
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "TOWN")
    private String town;

    @Column(name = "RADIUS")
    private BigDecimal radius;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "EMERALD_ID")
    private Emerald emerald;

    @NotNull
    @Column(name = "ENABLE")
    private boolean enable;
}
