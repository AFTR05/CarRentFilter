package com.example.carrent.controller.servlets;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.service.Impl.CarRent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SvLoan", value = "/register-loan")
public class SvLoan extends HttpServlet {
    private CarRent carRent;
    private ModelFactoryController mfc=ModelFactoryController.getInstance();

    public SvLoan(CarRent carRent) {
        this.carRent = carRent;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
