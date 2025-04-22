package com.dio.portfoliotracker.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String email;
    private List<Portfolio> portfolio;

    public Customer(String email, String name, List<Portfolio> portfolios) {
        this.email = email;
        this.name = name;
        this.portfolio = portfolios;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public List<Portfolio> getPortfolio() {
        return portfolio;
    }

    public void addPortfolio(Portfolio carteira) {
        if (carteira == null) {
            return;
        }

        if (this.portfolio == null) {
            this.portfolio = new ArrayList<>();
        }

        if (this.portfolio.contains(carteira)) {
            return;
        }

        this.portfolio.add(carteira);
    }

}
