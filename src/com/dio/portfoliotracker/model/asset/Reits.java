package com.dio.portfoliotracker.model.asset;

import java.math.BigDecimal;

import com.dio.portfoliotracker.model.AssetType;

public class Reits implements Asset {
    private final String ticker;
    private final String fundName;
    private BigDecimal currentPrice;

    public Reits(String ticker, String fundName, BigDecimal currentPrice) {
        this.ticker = ticker;
        this.fundName = fundName;
        this.currentPrice = currentPrice;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public AssetType getType() {
        return AssetType.REITS;
    }

    @Override
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public void updatePrice(BigDecimal newPrice) {
        this.currentPrice = newPrice;
    }

    @Override
    public BigDecimal getPriceFromService() {
        return this.currentPrice;
    }

    public String getFundName() {
        return fundName;
    }

}
