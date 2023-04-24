package com.example.carrent.controller.filters;


import com.example.carrent.service.Impl.LoginServiceSessionImp;
import com.example.carrent.service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter("/loan.jsp")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImp();
        Optional<String> username = service.getNickname((HttpServletRequest) request);
        Optional<String> password = service.getPassword((HttpServletRequest) request);
        if (username.isPresent() && password.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No estás autorizado para ingresar a esta página!");
        }
    }
}
