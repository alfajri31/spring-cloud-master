package com.cantimapp.adm.service;

import com.cantimapp.adm.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService implements IBookService{
    @Override
    public Collection<Book> getBooks() {
        Book book = new Book();
        book.setAuthor("Fajri");
        book.setIsbn("asdsdasdasdsa");
        book.setName("ALALALALALA");
        List<Book>books = new ArrayList<>();
        books.add(book);
        return books;
    }

    @Override
    public Book addBook(Book book) {
        return null;
    }
}
