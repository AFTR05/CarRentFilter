package com.example.carrent.controller.servlets;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.persistence.PersistenceClient;
import com.example.carrent.utilities.ConnectionData;
import com.example.carrent.utilities.GeneratorAlerts;
import com.example.carrent.utilities.LoginAction;
import com.example.carrent.validation.NullValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "SvLogin", value = "/login")
public class SvLogin extends HttpServlet {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mfc.getCarRent().getClientServiceImp().setListClients(ConnectionData.chargeDataSQL());
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        HashMap<String,String> errores=new HashMap<>(GeneratorAlerts.generateMessageLogin(nickname, password));
        if(NullValidation.nullLogin(nickname,password)){
            if (LoginAction.DefaultLogin(nickname,password)=="client"){
                response.sendRedirect("loan.jsp");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("errores",errores);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
