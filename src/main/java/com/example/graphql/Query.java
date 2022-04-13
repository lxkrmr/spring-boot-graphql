package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query  implements GraphQLQueryResolver {

    private final PostService postService;

    public Query(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getRecentPosts(int count, int offeset) {
        return postService.getRecentPosts(count, offeset);
    }
}
