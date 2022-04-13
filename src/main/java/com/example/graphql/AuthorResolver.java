package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

public class AuthorResolver implements GraphQLResolver<Author> {

    private PostService postService;

    public AuthorResolver(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPosts(Author author) {
        return postService.getAuthorPosts(author.id());
    }
}
