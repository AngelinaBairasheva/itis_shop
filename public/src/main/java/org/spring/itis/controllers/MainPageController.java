package org.spring.itis.controllers;


import org.spring.itis.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        return Constants.VIEW_MAIN;
    }
}
