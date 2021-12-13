package com.wipro.userinfoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserRecordNotFoundException extends RuntimeException 
{
    public UserRecordNotFoundException(String exception) {
        super(exception);
    }
}