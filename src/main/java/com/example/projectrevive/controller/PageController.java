package com.example.projectrevive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @RequestMapping("/viral")
    public String index() {
        return "viral";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/hello/{name}")
    public String helloPath(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/generator")
    public String generator(@RequestParam(value="a", required=false, defaultValue = "0") String a,
                            @RequestParam(value="b", required=false, defaultValue = "0") String b,
                            Model model) {
        String output = "";
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);

        if(aInt == 0 || aInt == 1 || bInt == 0 || bInt == 1) {
            output = "hm";
        } else {
            output = "";
            for(int bLoop = 0; bLoop < bInt; bLoop++) {
                output += "h";
                for(int aLoop = 0; aLoop < aInt; aLoop++) {
                    output += "m";
                }
                output += " ";
            }
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("output", output);

        return "generator";
    }
}
