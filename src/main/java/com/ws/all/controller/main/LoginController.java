package com.ws.all.controller.main;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public String login() {
        System.out.println("login-----222");
        return "success";
    }
}
