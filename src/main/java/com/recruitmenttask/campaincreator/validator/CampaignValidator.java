package com.recruitmenttask.campaincreator.validator;

import com.recruitmenttask.campaincreator.domain.Campaign;
import com.recruitmenttask.campaincreator.exceptiond.BidAmountNotValidException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CampaignValidator {
    public Campaign validateBidAmount(Campaign campaign) throws BidAmountNotValidException {
        if(campaign.getBidAmount().intValue() >= 50) {
            return campaign;
        }
        throw new BidAmountNotValidException();
    }
}
