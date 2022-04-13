package com.example.graphql;

public record Post(String id,
                   String title,
                   String text,
                   String category,
                   String authorId) {
}
