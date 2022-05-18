package com.recruitmenttask.campaincreator.controller.validator;

import com.recruitmenttask.campaincreator.controller.exception.BidAmountNotValidException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CampaignValidator {
    public BigDecimal validateBidAmount(BigDecimal bidAmount) throws BidAmountNotValidException {
        if(bidAmount.intValue() >= 50) {
            return bidAmount;
        }
        throw new BidAmountNotValidException();
    }
}
