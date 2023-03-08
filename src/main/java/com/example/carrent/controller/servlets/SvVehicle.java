package com.example.carrent.controller.servlets;

import com.example.carrent.service.Impl.CarRent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SvVehicle", value = "/register-vehicle")
public class SvVehicle extends HttpServlet {
    private CarRent carRent;

    public SvVehicle(CarRent carRent) {
        this.carRent = carRent;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
