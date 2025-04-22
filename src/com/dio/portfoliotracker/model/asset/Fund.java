package com.dio.portfoliotracker.model.asset;

import java.math.BigDecimal;
import com.dio.portfoliotracker.model.AssetType;

public class Fund implements Asset {
    private final String ticker;
    private final String companyName;
    private BigDecimal currentPrice;

    public Fund(String ticker, String companyName, BigDecimal currentPrice) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public AssetType getType() {
        return AssetType.FUND; 
    }

    @Override
    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }

    @Override
    public void updatePrice(BigDecimal newPrice) {
        this.currentPrice = newPrice;
    }

    @Override
    public BigDecimal getPriceFromService() {
        return currentPrice;
    }

    public String getCompanyName() {
        return companyName;
    }
}
