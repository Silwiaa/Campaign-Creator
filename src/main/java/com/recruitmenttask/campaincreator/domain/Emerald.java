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
@Entity(name ="EMERALD_ACCOUNT")
public class Emerald {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMERALD_ID")
    private Long emeraldId;

    @NotNull
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @OneToMany(
            targetEntity = Campaign.class,
            mappedBy = "emerald",
            cascade = CascadeType.ALL
    )
    private List<Campaign> campaigns;
}
