package com.kryakushin.SchoolSite.controllers;

import com.kryakushin.SchoolSite.models.Post;
import com.kryakushin.SchoolSite.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        List<Post> posts = postRepository.findAll();
        List<Long> id = new ArrayList<>();
        for (Post post : posts) {
            id.add(post.getId());
        }
        id.sort(Comparator.reverseOrder());
        posts.clear();
        for(Long g : id)
        {
            posts.add(postRepository.findPostById(g));
        }
        model.addAttribute("posts", posts);
        return "home";
    }

}
