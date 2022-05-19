package com.recruitmenttask.campaincreator.mapper;

import com.recruitmenttask.campaincreator.domain.Seller;
import com.recruitmenttask.campaincreator.domain.SellerDto;
import org.springframework.stereotype.Service;

@Service
public class SellerMapper {
    public SellerDto mapToSellerDto(Seller seller) {
        return SellerDto.builder()
                .sellerId(seller.getSellerId())
                .name(seller.getName())
                .emeraldId(seller.getEmerald().getEmeraldId())
                .active(seller.isActive())
                .enabled(seller.isEnabled())
                .build();
    }
}
