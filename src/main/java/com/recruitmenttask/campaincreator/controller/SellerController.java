package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.domain.SellerDto;
import com.recruitmenttask.campaincreator.exception.SellerAlreadyBlockedException;
import com.recruitmenttask.campaincreator.exception.SellerNotFoundException;
import com.recruitmenttask.campaincreator.mapper.SellerMapper;
import com.recruitmenttask.campaincreator.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerMapper sellerMapper;
    private final SellerService sellerService;

    @PutMapping("/{id}")
    public ResponseEntity<SellerDto> blockSeller(@PathVariable Long sellerId) throws SellerAlreadyBlockedException, SellerNotFoundException {
        return ResponseEntity.ok(sellerMapper.mapToSellerDto(sellerService.blockSeller(sellerId)));
    }
}
