package com.recruitmenttask.campaincreator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name ="KEYWORDS")
public class Keyword {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "KEYWORD_ID")
    private Long keywordId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CAMPAIGN_KEYWORD",
            joinColumns = {@JoinColumn(name = "KEYWORD_ID", referencedColumnName = "KEYWORD_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CAMPAIGN_ID", referencedColumnName = "CAMPAIGN_ID")}
    )
    private List<Campaign> campaigns;

    @NotNull
    @Column(name = "ACTIVE")
    private boolean active;
}
