package com.zihler.library.dataaccess;

import com.zihler.library.application.IRetrieveBooks;
import com.zihler.library.domain.Book;
import com.zihler.library.domain.Books;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository implements IRetrieveBooks {
    private final Books books;

    public BookRepository(ResourceLoader resourceLoader) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        resourceLoader.getResource("classpath:books.csv")
                                .getInputStream()
                )
        );

        this.books = new Books();

        while (bufferedReader.ready()) {
            books.add(Book.from(bufferedReader.readLine()));
        }
    }

    @Override
    public Books getAll() {
        return books;
    }

    @Override
    public Book getByKey(int key) {
        return this.books.get(key);
    }
}
