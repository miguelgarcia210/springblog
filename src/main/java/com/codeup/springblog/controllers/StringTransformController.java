package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverseString(@PathVariable String string) {
        return new StringBuilder(string).reverse().toString();
    }

    @GetMapping("/string/uppercase/{string}")
    @ResponseBody
    public String uppercaseString(@PathVariable String string) {
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String reverseUpperString(@PathVariable String string) {
        return reverseString(uppercaseString(string));
    }

    @GetMapping("/string/{string}")
    @ResponseBody
    public String manipulateString(@PathVariable String string,
                                   @RequestParam(value = "reverse", required = false, defaultValue = "false") Boolean reverse,
                                   @RequestParam(value = "caps", required = false, defaultValue = "false") Boolean caps
    ) {
        if (reverse && caps) {
            return reverseUpperString(string);
        } else if (reverse) {
            return reverseString(string);
        } else if (caps) {
            return uppercaseString(string);
        } else {
            return string;
        }
    }
}
