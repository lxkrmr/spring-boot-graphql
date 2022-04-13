package com.example.graphql;

import java.util.List;
import java.util.stream.Collectors;

public class PostService {
    private final List<Post> posts;

    public PostService(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count, int offeset) {
        return posts.stream()
                    .skip(offeset)
                    .limit(count)
                    .collect(Collectors.toList());
    }

    public void savePost(Post post) {
        posts.add(0, post);
    }

    public List<Post> getAuthorPosts(String id) {
        return posts.stream()
                    .filter(p -> p.authorId()
                                  .equals(id))
                    .collect(Collectors.toList());
    }
}
