package com.dio.portfoliotracker.model;

import com.dio.portfoliotracker.exception.InvalidPositionException;
import com.dio.portfoliotracker.exception.PortfolioException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private int id;
    private Customer owner;
    List<Position> positions;

    public Portfolio(Customer owner, List<Position> positions) {
        if (owner == null) {
            throw new InvalidPositionException("Portfolio owner cannot be null");
        }
        this.owner = owner;
        this.positions = positions != null ? positions : new ArrayList<>();
    }

    public boolean addPosition(Position position) {
        try {
            if (position == null) {
                throw new InvalidPositionException("Position cannot be null");
            }
            if (positions == null) {
                positions = new ArrayList<>();
            }
            if (positions.stream()
                    .anyMatch(p -> p.getAsset().getTicker().equals(position.getAsset().getTicker()))) {
                throw new InvalidPositionException("Position for asset " + position.getAsset().getTicker() + 
                    " already exists in portfolio");
            }
            return positions.add(position);
        } catch (Exception e) {
            throw new PortfolioException("Error adding position to portfolio", e);
        }
    }

    public boolean removePosition(Position position) {
        if (position == null || !positions.contains(position)) {
            return false;
        }
        positions.remove(position);
        return true;
    }

    public BigDecimal calculateTotalValue() {
        try {
            return positions.stream()
                .map(Position::calculateCurrentValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        } catch (Exception e) {
            throw new PortfolioException("Error calculating total portfolio value", e);
        }
    }

    public BigDecimal calculateTotalProfitLoss() {
        try {
            return positions.stream()
                .map(Position::calculateProfitLoss)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        } catch (Exception e) {
            throw new PortfolioException("Error calculating total portfolio profit/loss", e);
        }
    }

    public void generateReport() {
        try {
            System.out.println("Portfolio Report for " + owner.getName());
            System.out.println("Total Value: " + calculateTotalValue());
            System.out.println("Total Profit/Loss: " + calculateTotalProfitLoss());
            System.out.println("Positions: ");
            positions.forEach(position -> 
                System.out.println("- " + position.getAsset().getTicker() + 
                    ": " + position.calculateCurrentValue())
            );
        } catch (Exception e) {
            throw new PortfolioException("Error generating portfolio report", e);
        }
    }

}
