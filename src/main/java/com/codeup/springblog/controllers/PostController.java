package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    // ===== function to create an array list of Post object simulating data =====
    public ArrayList<Post> Posts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "title1", "description1"));
        posts.add(new Post(2, "title2", "description2"));
        posts.add(new Post(3, "title3", "description3"));
        posts.add(new Post(4, "title4", "description4"));
        posts.add(new Post(5, "title5", "description5"));

        return posts;
    }

    // ===== mapping to display all posts in the database =====
    @GetMapping("/posts")
    public String indexPage(Model model) {
//        ArrayList<Post> posts = Posts();
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    // ===== mapping to display a single post =====
    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable long id, Model model) {
//        ArrayList<Post> posts = Posts();
//        for (Post post : posts) {
//            if (post.getId() == id) {
//                model.addAttribute("post", post);
//            }
//        }
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    // ===== CREATE POST =====
    @GetMapping("/posts/create")
    public String createPost() {

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description,
                             Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        Post post = new Post(title, description);
        postDao.save(post);

        return "redirect:/posts/" + post.getId();
    }

    // ===== EDIT POST =====
    @GetMapping("/posts/edit")
    public String editPost(@RequestParam(name = "post_id") Long post_id,
                           @RequestParam(name = "edit") boolean edit,
                           @RequestParam(name = "delete") boolean delete, Model model) {
//        Post post = postDao.getOne(post_id);
//        postDao.delete(post);
        Post post = postDao.getOne(post_id);
        model.addAttribute("post_id", post.getId());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("description", post.getDescription());

        // TODO: test if edit or delete button was clicked
        if (edit) {
            System.out.println("edit button was clicked");
        } else if(delete) {
            System.out.println("delete button was clicked");
        }

            return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String submitEdit(@RequestParam(name = "post_id") Long post_id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description) {
        // retrieve post by id
        Post post = postDao.getOne(post_id);
        // set new inputs as properties to post
        post.setTitle(title);
        post.setDescription(description);
        // update post
        postDao.save(post);
        // return to single post page to view changes
        return "redirect:/posts/" + post.getId();

    }

    // ===== DELETE POST =====
    @GetMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "post_id") Long post_id) {


        return "redirect:/posts";
    }

}
