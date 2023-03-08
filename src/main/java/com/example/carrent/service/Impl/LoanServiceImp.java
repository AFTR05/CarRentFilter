package com.example.carrent.service.Impl;

import com.example.carrent.model.Loan;

import java.util.HashSet;

public class LoanServiceImp {
    private HashSet<Loan> listLoans;

    private CarRent carRent;

    public LoanServiceImp(CarRent carRent) {
        this.carRent = carRent;
    }

    public CarRent getCarRent() {
        return carRent;
    }

    public HashSet<Loan> getListLoans() {
        return listLoans;
    }

    public void setListLoans(HashSet<Loan> listLoans) {
        this.listLoans = listLoans;
    }
}
