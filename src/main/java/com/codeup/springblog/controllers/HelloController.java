package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello Deimos!";
    }

    @GetMapping("/hello/{cohort}")
    public String hello(@PathVariable String cohort, Model model) {
        model.addAttribute("cohort", cohort);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        ArrayList<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("Bread");
        shoppingCart.add("butter");
        shoppingCart.add("mustard");
        shoppingCart.add("ketchup");
        shoppingCart.add("lettuce");
        shoppingCart.add("tomato");
        shoppingCart.add("cheese");
        shoppingCart.add("patty");
        shoppingCart.add("bacon");

        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", cohort);
        return "join";
    }
}
