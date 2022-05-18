package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.exception.BidAmountNotValidException;
import com.recruitmenttask.campaincreator.exception.CampaignNotFoundException;
import com.recruitmenttask.campaincreator.exception.FundNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CampaignNotFoundException.class)
    public ResponseEntity<Object> handleCampaignNotFoundException(CampaignNotFoundException CampaignNotFoundException) {
        return new ResponseEntity<>("Campaign with given id doesn't exist or can't be found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BidAmountNotValidException.class)
    public ResponseEntity<Object> handleBidAmountNotValidException(BidAmountNotValidException bidAmountNotValidException) {
        return new ResponseEntity<>("Bid value needs to be bigger or equal to 50", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(FundNotFoundException.class)
    public ResponseEntity<Object> handleFundNotFoundException(FundNotFoundException fundNotFoundException) {
        return new ResponseEntity<>("Campaign fund with given id doesn't exist or can't be found", HttpStatus.NOT_FOUND);
    }
}
