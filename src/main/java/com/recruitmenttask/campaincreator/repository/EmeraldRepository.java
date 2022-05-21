package com.recruitmenttask.campaincreator.repository;

import com.recruitmenttask.campaincreator.domain.Emerald;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmeraldRepository extends CrudRepository<Emerald, Long> {
}
