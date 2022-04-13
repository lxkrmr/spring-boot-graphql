package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class PostResolver implements GraphQLResolver<Post> {

    private AuthorService authorService;

    public PostResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author getAuthor(Post post) {
        return authorService.getAuthor(post.authorId())
                            .orElseThrow(RuntimeException::new);
    }
}
