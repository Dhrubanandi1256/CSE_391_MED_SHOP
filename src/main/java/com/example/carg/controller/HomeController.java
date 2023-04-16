package com.example.carg.controller;

import com.example.carg.model.UserDtls;
import com.example.carg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
    @Autowired
    private UserService userService;
//    @GetMapping("/")
//    public String index()
//    {
//
//        return "index";
//    }
//    @GetMapping("shop1")
//    public String shop()
//    {
//        return "shop1";
//    }
    @GetMapping("/signin")
    public String login()
    {
        return "login";
    }
    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session) {
        boolean f = userService.checkEmail(user.getEmail());
        if (f) {
            session.setAttribute("msg","email id already exist");
        } else {
            UserDtls userDtls = userService.createUser(user);
            //System.out.println(user);
            if (userDtls != null) {

                //System.out.println("Register sucessfully");
                session.setAttribute("msg","register successfully");


            } else {
                //System.out.println("something error in server");
                session.setAttribute("msg","something wrong in server");
            }
        }
            return "redirect:/register";
        }

    }




