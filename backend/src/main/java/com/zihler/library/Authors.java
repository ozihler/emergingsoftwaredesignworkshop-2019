package com.zihler.library;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Authors {
    private final List<Author> authors;

    private Authors(List<Author> authors) {
        this.authors = authors;
    }

    static Authors from(String authors) {
        return new Authors(Arrays.stream(authors.split(","))
                .map(Author::new)
                .collect(toList()));
    }

    @Override
    public String toString() {
        return authors
                .stream()
                .map(Author::getName)
                .collect(Collectors.joining(","));
    }
}
