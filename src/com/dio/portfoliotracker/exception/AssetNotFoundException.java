package com.dio.portfoliotracker.exception;

public class AssetNotFoundException extends PortfolioException {
    public AssetNotFoundException(String ticker) {
        super("Asset not found with ticker: " + ticker);
    }
}
