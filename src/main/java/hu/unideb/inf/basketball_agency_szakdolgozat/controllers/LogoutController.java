package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LogoutController {

    @Autowired
    private HomeController homeController;

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, Model model, HttpServletResponse response) {
        try {
            request.logout();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        response.setHeader("Location", "/");
        response.setStatus(302);
    }
}
