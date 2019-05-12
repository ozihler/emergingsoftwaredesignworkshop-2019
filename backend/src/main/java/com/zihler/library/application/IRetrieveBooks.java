package com.zihler.library.application;

import com.zihler.library.domain.Book;

import java.util.List;

public interface IRetrieveBooks {
    List<Book> getAll();

    Book getByKey(int key);
}
