package com.recruitmenttask.campaincreator.controller;

import com.recruitmenttask.campaincreator.exception.*;
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

    @ExceptionHandler(EmeraldNotFoundException.class)
    public ResponseEntity<Object> handleEmeraldNotFoundException(EmeraldNotFoundException emeraldNotFoundException) {
        return new ResponseEntity<>("Emerald with given id doesn't exist or can't be found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<Object> handleSellerNotFoundException(SellerNotFoundException sellerNotFoundException) {
        return new ResponseEntity<>("Seller with given id doesn't exist or can't be found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SellerAlreadyBlockedException.class)
    public ResponseEntity<Object> handleSellerAlreadyBlockedException(SellerAlreadyBlockedException sellerAlreadyBlockedException) {
        return new ResponseEntity<>("Seller with given id already blocked in the system", HttpStatus.CONFLICT);
    }
}
