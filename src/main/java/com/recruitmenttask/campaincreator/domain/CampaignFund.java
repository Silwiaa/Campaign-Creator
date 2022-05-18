package com.recruitmenttask.campaincreator.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity(name ="CAMPAIGNS_Founds")
public class CampaignFund {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FOUND_ID")
    private Long foundId;

    @NotNull
    @Column(name = "FOUND_VALUE")
    private BigDecimal fundValue;
}
