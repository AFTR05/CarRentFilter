package com.example.carrent.service.Impl;

import com.example.carrent.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LoginServiceSessionImp implements LoginService {
    @Override
    public Optional<String> getNickname(HttpServletRequest req) {
       HttpSession session = req.getSession();
       String nickname = (String) session.getAttribute("nickname");
        if (nickname != null) {
            return Optional.of(nickname);
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> getPassword(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            return Optional.of(password);
        }
        return Optional.empty();
    }
}
