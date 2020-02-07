package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookControllerTest {

    @Autowired
    BookServiceImpl bookService;

    @Test
    void bookListTest(){
        List<Book> allBooks = bookService.findALLBooks();
        for (Book allBook : allBooks) {
            System.out.println(allBook.getBookName());
            System.out.println(allBook.getBookPubDate());
        }
    }
}