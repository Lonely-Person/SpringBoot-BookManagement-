package com.example.demo.controller;

import com.example.demo.dao.BookCategoryDao;
import com.example.demo.dao.BookDao;
import com.example.demo.domain.Book;
import com.example.demo.domain.BookCategory;
import com.example.demo.domain.Borrow;
import com.example.demo.service.impl.BookServiceImpl;
import com.example.demo.service.impl.BorrowServiceImpl;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    BookCategoryDao bookCategoryDao;

    @Autowired
    BorrowServiceImpl borrowService;

    @GetMapping("book-list")
    public String allBookList(Model model) {
        List<Book> allBooks = bookService.findALLBooks();
        model.addAttribute("bookList", allBooks);
        return "book-list";
    }

    @GetMapping("query/{bookName}")
    public String findBookByName(@PathVariable("bookName") String bookName, Model model) {
        List<Book> books = bookService.findBookByName(bookName);
        model.addAttribute(books);
        return "book-list";
    }

    @GetMapping("category")
    @ResponseBody
    public Set<Book> findBookByCategory() {
        BookCategory bookCategory = bookCategoryDao.findById(1L).orElse(null);
        Set<Book> categoryBook = bookCategory.getCategoryBooks();
        for (Book book : categoryBook) {
            System.out.println(book);
        }
        return categoryBook;
    }

    @GetMapping("bookDetails/{bookId}")
    public String bookDetails(@PathVariable("bookId")Long bookId, Model model){
        Book book = bookService.findBookById(bookId);
        model.addAttribute("book", book);
        return "book-detail";
    }

    @GetMapping("addBook")
    public String addBook(){
        return "add-book";
    }

    @PostMapping("doAddBook")
    @ResponseBody
    public String doAddBook(Book book){

        bookService.add(book);
        return "添加图书成功";
    }
}
