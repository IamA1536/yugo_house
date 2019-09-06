package org.csu.sfteam.house_web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kemp on 2018/8/15.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String viewMain() {
        return "index";
    }

    @GetMapping("/help")
    public String viewHelp(){
        return "help";
    }
}

