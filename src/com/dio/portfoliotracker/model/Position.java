package com.dio.portfoliotracker.model;

import com.dio.portfoliotracker.exception.InvalidPositionException;
import com.dio.portfoliotracker.exception.PortfolioException;
import com.dio.portfoliotracker.model.asset.Asset;
import java.math.BigDecimal;

public class Position {

    private Asset asset;
    private BigDecimal quantity;
    private BigDecimal averagePrice;

    public Position(Asset asset, BigDecimal quantity, BigDecimal averagePrice) {
        validatePosition(asset, quantity, averagePrice);
        this.asset = asset;
        this.quantity = quantity;
        this.averagePrice = averagePrice;
    }

    public BigDecimal calculateCurrentValue() {
        try {
            return this.asset.getCurrentPrice().multiply(quantity);
        } catch (Exception e) {
            throw new PortfolioException("Error calculating current value", e);
        }
    }

    public BigDecimal calculateProfitLoss() {
        try {
            return calculateCurrentValue().subtract(averagePrice.multiply(quantity));
        } catch (Exception e) {
            throw new PortfolioException("Error calculating profit/loss", e);
        }
    }

    public Asset getAsset() {
        return this.asset;
    }

    private void validatePosition(Asset asset, BigDecimal quantity, BigDecimal averagePrice) {
        if (asset == null) {
            throw new InvalidPositionException("Asset cannot be null");
        }
        if (quantity == null || quantity.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPositionException("Quantity must be greater than zero");
        }
        if (averagePrice == null || averagePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPositionException("Average price must be greater than zero");
        }
    }

}
