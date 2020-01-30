package com.kkukielka.springrestclient.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostControllerTest {

    @Autowired
    ApplicationContext context;

    WebTestClient webTestClient;

    @Before
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void index() {

        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    public void listPosts() {

        webTestClient.get().uri("/posts")
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    public void getPost() {
        webTestClient.get().uri("/posts/1")
                .exchange()
                .expectStatus().isOk();
    }
}