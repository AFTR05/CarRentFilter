package com.example.carrent.model;

import jakarta.inject.Named;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Loan implements Serializable {
    private LocalDateTime beginLoan;
    private Client client;
    private Vehicle vehicle;

    public Loan(LocalDateTime beginLoan, Client client, Vehicle vehicle) {
        this.beginLoan = beginLoan;
        this.client = client;
        this.vehicle = vehicle;
    }

    public Loan(){

    }

    public LocalDateTime getBeginLoan() {
        return beginLoan;
    }

    public void setBeginLoan(LocalDateTime beginLoan) {
        this.beginLoan = beginLoan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
