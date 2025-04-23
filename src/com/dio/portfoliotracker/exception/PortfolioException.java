package com.dio.portfoliotracker.exception;

public class PortfolioException extends RuntimeException {
    public PortfolioException(String message) {
        super(message);
    }

    public PortfolioException(String message, Throwable cause) {
        super(message + ": " + cause.getMessage());
    }
}
