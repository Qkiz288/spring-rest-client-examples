package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Post;
import com.kkukielka.api.domain.PostsData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${api.url.posts}")
    private String posts_url;

    @Value("${api.url.post}")
    private String post_url;

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Post> listPosts() {

        List<Post> postsData = restTemplate
                .getForObject(posts_url, List.class);

        return postsData;
    }

    @Override
    public Mono<Post> getPost(Mono<Integer> id) {

        return WebClient.create(post_url)
                .get()
                .uri(uriBuilder -> uriBuilder.path("").build(id.block()))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Post.class);
    }


}
