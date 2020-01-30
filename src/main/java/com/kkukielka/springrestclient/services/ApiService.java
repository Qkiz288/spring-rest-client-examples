package com.kkukielka.springrestclient.services;

import com.kkukielka.api.domain.Post;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApiService {

    List<Post> listPosts();

    Mono<Post> getPost(Mono<Integer> id);

}
