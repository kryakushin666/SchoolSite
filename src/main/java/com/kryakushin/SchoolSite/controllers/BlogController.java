package com.kryakushin.SchoolSite.controllers;

import com.kryakushin.SchoolSite.models.Post;
import com.kryakushin.SchoolSite.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        model.addAttribute("title", "Adding article");
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @RequestParam("url") String url, Model model) {
        Date current = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
        Post post = null;
        if(url.isEmpty()) post = new Post(title, anons, full_text, null, sdf.format(current));
        else post = new Post(title, anons, full_text, url, sdf.format(current));
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)) {
            return "redirect:/";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        model.addAttribute("title", res.get(0).getTitle() + " | School 59");
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)) {
            return "redirect:/";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        model.addAttribute("title", res.get(0).getTitle() + " | School 59");
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @RequestParam("options") String type, Model model) throws Exception {
        Post post = postRepository.findById(id).orElseThrow(Exception::new);
        post.setTitle(title);
        post.setAnons(anons);
        postRepository.save(post);
        return "redirect:/";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) throws Exception {
        Post post = postRepository.findById(id).orElseThrow(Exception::new);
        postRepository.delete(post);
        return "redirect:/";
    }
}