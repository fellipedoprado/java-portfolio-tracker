package com.dio.portfoliotracker.model.asset;

import java.math.BigDecimal;
import com.dio.portfoliotracker.model.AssetType;

public interface Asset {
    String getTicker();
    AssetType getType();
    BigDecimal getCurrentPrice();
    void updatePrice(BigDecimal newPrice);
    BigDecimal getPriceFromService();
}
