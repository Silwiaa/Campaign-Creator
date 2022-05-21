package com.recruitmenttask.campaincreator.repository;

import com.recruitmenttask.campaincreator.domain.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {
    @Override
    List<Campaign> findAll();
}
