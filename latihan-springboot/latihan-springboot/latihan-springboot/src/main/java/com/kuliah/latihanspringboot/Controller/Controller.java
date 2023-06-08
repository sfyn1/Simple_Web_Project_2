package com.kuliah.latihanspringboot.Controller;

import com.kuliah.latihanspringboot.Model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.sax.SAXResult;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping
@Slf4j
public class Controller {

    @GetMapping(value = "/login")
    public String openLoginPage(Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        model.addAttribute("loginInput", new User());
        return "login";
    }

    @GetMapping(value = "/register")
    public String openRegisterPage(Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        return "register";
    }

    @GetMapping(value = "/dashboard")
    public String openDashboardPage(Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        return "dashboard";
    }

    @PostMapping(value = "/login")
    public String submitLogin(@ModelAttribute("loginInput") User user, Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        log.info("LOGIN ATTEMPT");
        log.info("username: {}", user.getUsername());
        log.info("password: {}", user.getPassword());

        if (user.getUsername().matches("sufyan")) {
            log.info("user with username {} exists", user.getUsername());
            if (user.getPassword().matches("123") != true) {
                log.info("Wrong Password", user.getUsername());
                System.out.println("\n");
                log.info("LOGIN FAILED");
                return "/login";
            } else {
                System.out.println("\n");
                log.info("LOGIN SUCCES");
                return "/dashboard";
            }
        } else {
            log.info("user with username {} does not exists", user.getUsername());
            System.out.println("\n");
            log.info("LOGIN FAILED");
            return "/login";
        }
    }
}