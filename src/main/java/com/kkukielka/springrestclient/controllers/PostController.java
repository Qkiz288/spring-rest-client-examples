package com.kkukielka.springrestclient.controllers;


import com.kkukielka.api.domain.Post;
import com.kkukielka.springrestclient.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class PostController {

    private ApiService apiService;

    public PostController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/posts")
    public String listPosts(Model model) {
        log.debug("Entered listPosts");

        model.addAttribute("posts", apiService.listPosts());

        return "postslist";
    }

    @ResponseBody
    @GetMapping("/posts/{id}")
    public Mono<Post> getPostById(Model model, @PathVariable String id) {
        log.debug("Entered getPostById");

        return apiService.getPost(Mono.just(Integer.valueOf(id)));
    }
}
