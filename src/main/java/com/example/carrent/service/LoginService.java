package com.example.carrent.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    Optional<String> getNickname(HttpServletRequest req);
    Optional<String> getPassword(HttpServletRequest req);
}
