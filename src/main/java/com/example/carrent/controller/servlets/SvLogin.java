package com.example.carrent.controller.servlets;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.persistence.PersistenceClient;
import com.example.carrent.utilities.LoginAction;
import com.example.carrent.validation.NullValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvLogin", value = "/login")
public class SvLogin extends HttpServlet {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mfc.getCarRent().getClientServiceImp().setListClients(PersistenceClient.chargeClient());
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        if(NullValidation.nullLogin(nickname,password)){
            if (LoginAction.DefaultLogin(nickname,password)=="client"){
                response.sendRedirect("loan.jsp");
            }
        }
    }
}
