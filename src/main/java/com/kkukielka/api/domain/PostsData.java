package com.kkukielka.api.domain;

import java.util.List;

public class PostsData {
    List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
