package com.cantimapp.adm.service;

import com.cantimapp.adm.model.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface IBookService {
    Collection<Book> getBooks();
    Book addBook(Book book);
}