package com.dio.portfoliotracker.model;

import com.dio.portfoliotracker.exception.CustomerException;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String email;
    private List<Portfolio> portfolio;

    public Customer(String email, String name, List<Portfolio> portfolios) {
        validateCustomerData(email, name);
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
        return portfolio != null ? new ArrayList<>(portfolio) : new ArrayList<>();
    }

    public void addPortfolio(Portfolio portfolio) {
        if (portfolio == null) {
            throw new CustomerException("Portfolio cannot be null");
        }

        if (this.portfolio == null) {
            this.portfolio = new ArrayList<>();
        }

        if (this.portfolio.contains(portfolio)) {
            throw new CustomerException("Portfolio already exists for this customer");
        }

        this.portfolio.add(portfolio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Customer other = (Customer) obj;
        return email != null && email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    private void validateCustomerData(String email, String name) {
        if (email == null || email.trim().isEmpty()) {
            throw new CustomerException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new CustomerException("Invalid email format");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new CustomerException("Name cannot be null or empty");
        }
    }

}
