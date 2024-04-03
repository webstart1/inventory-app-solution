package com.piquota.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppExceptionHandler {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AppException.class)
    public ResponseEntity<String> handlAppException(AppException ex) {
        String res = "";

        switch (ex.getErrorCode()) {
            case (201):
                res = "Error in getting inventory item";
                break;
            case (202):
                res = "Error in adding inventory item";
                break;
            case (203):
                res = "Error in removing inventory item";
                break;


        }

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
