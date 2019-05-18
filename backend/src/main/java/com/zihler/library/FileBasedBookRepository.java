package com.zihler.library;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileBasedBookRepository implements BookRepository {
    private final List<Book> books;

    public FileBasedBookRepository(ResourceLoader resourceLoader) throws IOException {
        books = new ArrayList<>();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceLoader.getResource("classpath:books.csv").getInputStream()));
        while (bufferedReader.ready()) {
            books.add(Book.from(bufferedReader.readLine()));
        }
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book findByKey(int key) {
        return this.books.get(key);
    }
}
