package com.example.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public PostService postService() {
        ArrayList<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post("Post" + authorId + postId,
                                     "Post " + authorId + ":" + postId,
                                     "Post " + postId + " + by author " + authorId,
                                     "Post category",
                                     "Author" + authorId
                );
                posts.add(post);
            }
        }
        return new PostService(posts);
    }

    @Bean
    public AuthorService authorService() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author("Author" + authorId,
                                       "Author " + authorId,
                                       "http://example.com/authors/" + authorId);
            authors.add(author);
        }
        return new AuthorService(authors);
    }

    @Bean
    public PostResolver postResolver(AuthorService authorService) {
        return new PostResolver(authorService);
    }

    @Bean
    public AuthorResolver authorResolver(PostService postService) {
        return new AuthorResolver(postService);
    }

    @Bean
    public Query query(PostService postService) {
        return new Query(postService);
    }

    @Bean
    public Mutation mutation(PostService postService) {
        return new Mutation(postService);
    }
}
