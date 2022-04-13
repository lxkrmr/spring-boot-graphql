package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import java.util.UUID;

public class Mutation implements GraphQLMutationResolver {

    private PostService postService;

    public Mutation(PostService postService) {
        this.postService = postService;
    }

    public Post writePost(String title, String text, String category, String author) {
        Post post = new Post(UUID.randomUUID()
                                 .toString(),
                             title,
                             text,
                             category,
                             author
        );

        postService.savePost(post);

        return post;
    }
}
