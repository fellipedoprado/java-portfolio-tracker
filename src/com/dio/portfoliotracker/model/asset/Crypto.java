package com.dio.portfoliotracker.model.asset;

import com.dio.portfoliotracker.model.AssetType;
import java.math.BigDecimal;

public class Crypto implements Asset {
    private final String ticker;
    private final String network;
    private BigDecimal currentPrice;

    public Crypto(String ticker, String coinName, BigDecimal currentPrice) {
        this.ticker = ticker;
        this.network = coinName;
        this.currentPrice = currentPrice;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public AssetType getType() {
        return AssetType.CRYPTO;
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
        // TODO: implementar integração com serviço de preço de criptomoedas
        return currentPrice;
    }

    public String getNetwork() {
        return network;
    }

}
