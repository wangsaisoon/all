package com.ws.all.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "main")
public class MainController {

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();

        System.out.println("index");
        mv.setViewName("main/index");
        return mv;
    }


    @RequestMapping(value = "/defaults")
    public ModelAndView defaults() {
        ModelAndView mv = new ModelAndView();

        System.out.println("defaults");
        mv.setViewName("main/defaults");
        return mv;
    }
}
