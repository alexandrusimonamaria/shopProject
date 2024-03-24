package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/market")
    public String market() {
        return TemplatesNames.MARKET_PAGE;
    }

    @GetMapping("/home")
    public String homePage() {
        return TemplatesNames.HOME_PAGE;
    }

    @GetMapping("/administration")
    public String administrationPage() {
        return TemplatesNames.ADMINISTRATION_PAGE;
    }

//    @GetMapping("/")
//    String index(Principal principal) {
//        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
//
//    }
}
