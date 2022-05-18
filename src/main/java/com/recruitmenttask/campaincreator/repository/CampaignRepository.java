package com.recruitmenttask.campaincreator.repository;

import com.recruitmenttask.campaincreator.domain.Campaign;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {
}
