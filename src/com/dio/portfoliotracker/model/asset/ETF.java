package com.dio.portfoliotracker.model.asset;

import java.math.BigDecimal;
import com.dio.portfoliotracker.model.AssetType;

public class ETF implements Asset {
    private final String ticker;
    private final String fundName;
    private BigDecimal currentPrice;

    public ETF(String ticker, String fundName, BigDecimal currentPrice) {
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
        return com.dio.portfoliotracker.model.asset.ETF;
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
        // TODO: implementar integração com serviço de preço de ETF
        return currentPrice;
    }

    public String getFundName() {
        return fundName;
    }

}
