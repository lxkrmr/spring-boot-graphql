package com.example.graphql;

import java.util.List;
import java.util.Optional;

public class AuthorService {

    private final List<Author> authors;

    public AuthorService(List<Author> authors) {
        this.authors = authors;
    }

    public Optional<Author> getAuthor(String authorId) {
        return authors.stream()
                      .filter(a -> a.id().equals(authorId))
                      .findFirst();
    }
}
