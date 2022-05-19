package com.recruitmenttask.campaincreator.repository;

import com.recruitmenttask.campaincreator.domain.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
}
