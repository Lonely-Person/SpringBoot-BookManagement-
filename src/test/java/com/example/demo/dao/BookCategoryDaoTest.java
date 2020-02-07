package com.example.demo.dao;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookCategory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookCategoryDaoTest {

    @Autowired
    BookCategoryDao bookCategoryDao;

    @Test
    public void setBookCategoryDao(){
        BookCategory bookCategory = bookCategoryDao.findById(1L).orElse(null);
        Set<Book> categoryBook = bookCategory.getCategoryBooks();
        for (Book book : categoryBook) {
            System.out.println(book);
        }
    }
}