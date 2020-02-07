package com.example.demo.service.impl;

import com.example.demo.dao.BookDao;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> findALLBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findBookByName(String bookName) {
        return bookDao.findBookByBookNameLike(bookName);
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookDao.findById(bookId).orElse(null);
    }

    @Override
    public void add(Book book) {
        bookDao.save(book);
    }

    @Override
    public void saveAndFlush(Book book) {
        bookDao.saveAndFlush(book);
    }
}
