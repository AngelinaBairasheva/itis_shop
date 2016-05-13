package org.spring.itis.controllers;


import org.itis.hib.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        return Constants.ATTR_MAIN;
    }
}
