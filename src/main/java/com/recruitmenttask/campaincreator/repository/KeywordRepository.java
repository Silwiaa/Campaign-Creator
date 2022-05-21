package com.recruitmenttask.campaincreator.repository;

import com.recruitmenttask.campaincreator.domain.Keyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends CrudRepository<Keyword, Long> {
}
