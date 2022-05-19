package com.recruitmenttask.campaincreator.service;

import com.recruitmenttask.campaincreator.domain.Seller;
import com.recruitmenttask.campaincreator.exception.SellerAlreadyBlockedException;
import com.recruitmenttask.campaincreator.exception.SellerNotFoundException;
import com.recruitmenttask.campaincreator.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    private void saveSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    public Seller blockSeller(Long sellerId) throws SellerNotFoundException, SellerAlreadyBlockedException {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(SellerNotFoundException::new);

        if (!seller.isEnabled()) {
            throw new SellerAlreadyBlockedException();
        }

        seller.setEnabled(false);
        saveSeller(seller);
        return seller;
    }
}
