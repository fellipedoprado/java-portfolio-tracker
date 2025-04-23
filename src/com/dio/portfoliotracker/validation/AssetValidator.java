package com.dio.portfoliotracker.validation;

import java.math.BigDecimal;

import com.dio.portfoliotracker.exception.AssetValidationException;

public class AssetValidator {
    
    public static void validateAsset(String ticker, String name, BigDecimal price) {
        validateTicker(ticker);
        validateName(name);
        validatePrice(price);
    }

    public static void validateTicker(String ticker) {
        if (ticker == null || ticker.trim().isEmpty()) {
            throw new AssetValidationException("Ticker cannot be null or empty");
        }
        if (!ticker.matches("^[A-Z0-9.]{1,10}$")) {
            throw new AssetValidationException("Invalid ticker format");
        }
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new AssetValidationException("Name cannot be null or empty");
        }
    }

    public static void validatePrice(BigDecimal price) {
        if (price == null) {
            throw new AssetValidationException("Price cannot be null");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new AssetValidationException("Price cannot be negative");
        }
    }
}
