package com.dio.portfoliotracker.model.asset;

import com.dio.portfoliotracker.model.AssetType;
import java.math.BigDecimal;

public class Equity implements Asset {
    private final String ticker;
    private final String companyName;
    private BigDecimal currentPrice;

    public Equity(String ticker, String companyName, BigDecimal currentPrice) {
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
        return AssetType.EQUITY;
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
        // TODO: implementar integração com serviço de preço de ações
        return currentPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

}
