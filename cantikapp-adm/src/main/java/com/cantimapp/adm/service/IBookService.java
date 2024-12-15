package com.cantimapp.adm.service;

import com.cantimapp.adm.model.Book;

import java.util.Collection;


public interface IBookService {
    Collection<Book> getBooks();
    Book addBook(Book book);
}
