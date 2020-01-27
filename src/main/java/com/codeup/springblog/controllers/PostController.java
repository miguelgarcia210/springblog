package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage() {
        return "This is the posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postPage(@PathVariable int id) {
        return "This is an individual post page for " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This is the post creation page";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost() {
        return "This is what will happen when post is submitted";
    }

}
