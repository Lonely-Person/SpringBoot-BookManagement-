package com.example.demo.service;


import com.example.demo.dao.BookDao;
import com.example.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> findALLBooks();

    List<Book> findBookByName(String bookName);

    Book findBookById(Long bookId);

    void add(Book book);

    void saveAndFlush(Book book);

}
