package com.example.carrent.controller.servlets;

import java.io.*;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.persistence.PersistenceClient;
import com.example.carrent.service.Impl.CarRent;
import com.example.carrent.service.Impl.ClientServiceImp;
import com.example.carrent.validation.CreateValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SvClient", value = "/register-client")
public class SvClient extends HttpServlet {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mfc.getCarRent().getClientServiceImp().setListClients(PersistenceClient.chargeClient());
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        String confirmPassword=request.getParameter("confirmpassword");
        if (CreateValidation.registerClient(nickname,password,confirmPassword,mfc.getCarRent().getClientServiceImp().getListClients())){
            mfc.createClient(nickname,password);
            PersistenceClient.saveClient(mfc.getCarRent().getClientServiceImp().getListClients());
            response.sendRedirect("index.jsp");
        }

    }
}