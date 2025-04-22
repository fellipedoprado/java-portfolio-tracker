package com.dio.portfoliotracker.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private int id;
    private Customer owner;
    List<Position> positions;

    public Portfolio(Customer owner, List<Position> positions) {
        this.owner = owner;
        this.positions = positions;
    }

    public boolean addPosition(Position position) {
        if (position == null) {
            return false;
        }
        if (positions == null) {
            positions = new ArrayList<>();
        }
        if (positions.contains(position)) {
            return false;
        }
        positions.add(position);
        return true;
    }

    public boolean removePosition(Position position) {
        if (position == null || !positions.contains(position)) {
            return false;
        }
        positions.remove(position);
        return true;
    }

    public BigDecimal calculateTotalValue() {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (Position position : positions) {
            totalValue = totalValue.add(position.calculateCurrentValue());
        }
        return totalValue;
    }

    public BigDecimal calculateTotalProfitLoss() {
        BigDecimal totalProfitLoss = BigDecimal.ZERO;
        for (Position position : positions) {
            totalProfitLoss = totalProfitLoss.add(position.calculateProfitLoss());
        }
        return totalProfitLoss;
    }

    public void generateReport() {
        System.out.println("Portfolio Report for " + owner.getName());
        System.out.println("Total Value: " + calculateTotalValue());
        System.out.println("Total Profit/Loss: " + calculateTotalProfitLoss());
        System.out.println("Positions: ");
        for (Position position : positions) {
            System.out.println("- " + position.getAsset().getTicker() + ": " + position.calculateCurrentValue());
        }
    }

}
