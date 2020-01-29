package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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

    @GetMapping("/subtract/{n1}/from/{n2}")
    @ResponseBody
    public String subtractTwoNumbers(@PathVariable int n1, @PathVariable int n2) {
        return "The subtraction amounted to " + (n2 - n1);
    }

    @GetMapping("/multiply/{n1}/and/{n2}")
    @ResponseBody
    public String multiplyTwoNumbers(@PathVariable int n1, @PathVariable int n2) {
        return "The product of these two numbers is " + (n1 * n2);
    }

    @GetMapping("/divide/{n1}/by/{n2}")
    @ResponseBody
    public String divideTwoNumbers(@PathVariable double n1, @PathVariable double n2) {
        if (n2 == 0) {
            return n1 + " divided by " + n2 + " is 0";
        }
        
        return n1 + " divided by " + n2 + " is " + (n1/n2);
    }
}
