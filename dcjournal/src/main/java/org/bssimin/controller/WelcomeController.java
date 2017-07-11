package org.bssimin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by joo on 2017. 5. 23..
 */


@Controller
public class WelcomeController {
    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @RequestMapping("/tiny")
    public String tinyMCE(){
        return "/text/tiny" ;
    }

    @RequestMapping("/ckEditor")
    public String ckEditor(){
        return "/text/ckEditor";
    }

    @RequestMapping("/fileBrowser")
    public String fileBrowser(){
        return "/popUp/fileBrowser";
    }
}
