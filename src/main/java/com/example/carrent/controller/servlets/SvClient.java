package com.example.carrent.controller.servlets;

import java.io.*;
import java.sql.*;
import java.util.HashMap;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.persistence.PersistenceClient;
import com.example.carrent.service.Impl.CarRent;
import com.example.carrent.service.Impl.ClientServiceImp;
import com.example.carrent.utilities.GeneratorAlerts;
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
        }else{
            HashMap<String,String> errores=new HashMap<>(GeneratorAlerts.generateMessageRegister(nickname, password, confirmPassword));
            HttpSession session = request.getSession();
            session.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
            session.setAttribute("errores",null);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url="jdbc:mysql://localhost/carrent";
        String nickname="root";
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/carrent","root","");
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM carrent");
            while (rs.next()){
                System.out.println(rs.getString("nickname"));
            }
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}