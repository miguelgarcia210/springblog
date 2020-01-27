package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{n1}/and/{n2}")
    @ResponseBody
    public String addTwoNumbers(@PathVariable int n1, @PathVariable int n2) {
        return "The sum of the two is " + (n1 + n2);
    }
}
