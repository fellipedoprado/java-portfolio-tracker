package com.dio.portfoliotracker.model;

import java.math.BigDecimal;
import com.dio.portfoliotracker.model.asset.Asset;

public class Position {

    private Asset asset;
    private BigDecimal quantity;
    private BigDecimal averagePrice;

    public Position(Asset asset, BigDecimal quantity, BigDecimal averagePrice) {
        this.asset = asset;
        this.quantity = quantity;
        this.averagePrice = averagePrice;
    }

    public BigDecimal calculateCurrentValue() {
        return this.asset.getCurrentPrice().multiply(quantity);
    }

    public BigDecimal calculateProfitLoss() {
        return calculateCurrentValue().subtract(averagePrice.multiply(quantity));
    }

    public Asset getAsset() {
        return this.asset;
    }

}
