package com.dio.portfoliotracker.exception;

public class AssetValidationException extends Exception {
    public AssetValidationException(String message) {
        super(message);
    }

    public AssetValidationException(String message, Throwable cause) {
        super(message + ": " + cause.getMessage());
    }

}
