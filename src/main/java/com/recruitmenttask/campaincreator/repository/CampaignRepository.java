package com.recruitmenttask.campaincreator.repository;

import com.recruitmenttask.campaincreator.domain.Campaign;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {
    @Override
    List<Campaign> findAll();
}
