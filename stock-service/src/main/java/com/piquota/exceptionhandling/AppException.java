package com.piquota.exceptionhandling;

public class AppException extends Exception {

    private final int errorCode;
    private final String errorMessage;

    public AppException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }



}
