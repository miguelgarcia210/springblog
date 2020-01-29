package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeimosDevDayController {
    @GetMapping("/deimos/{number}")
    @ResponseBody
    public String developerDayNumber(@PathVariable int number) {
        return number + " more days until Deimos Developer Day!";
    }

    @GetMapping("/deimos")
    @ResponseBody
    public String developerDay() {
        return "31 more days until Deimos Developer Day!";
    }
}
