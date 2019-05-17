package com.zihler.library.application;

import com.zihler.library.domain.Book;
import com.zihler.library.domain.Books;

import java.util.List;

public interface IRetrieveBooks {
    Books getAll();

    Book getByKey(int key);
}
