package com.example.demo.controller;


import com.example.demo.dao.StudentDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Book;
import com.example.demo.domain.Borrow;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.impl.AccountDatabaseServiceImpl;
import com.example.demo.service.impl.BookServiceImpl;
import com.example.demo.service.impl.BorrowServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
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
@RequestMapping("user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @Autowired
    AccountDatabaseServiceImpl accountService;

    @Autowired
    BorrowServiceImpl borrowService;

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("person-message")
    public String personMessage(){
        return "user-message";
    }


    @GetMapping("borrowing/{bookId}")
    @ResponseBody
    public String bookBorrowCurrent(@PathVariable("bookId")Long bookId, HttpServletRequest req){
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        if (user.getCurrentBorrowNumbers()>=10){
            return "您目前只能借阅10本图书";
        }
        return userService.addBorrowingBook(userId, bookId);
    }
    @GetMapping("current-borrow")
    public String bookBorrowed(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        List<Book> userBorrowBook = userService.findCurrentBorrowBook(userId);
        model.addAttribute("currentBorrow", userBorrowBook);
        model.addAttribute("userCurrentBorrowNum", user.getCurrentBorrowNumbers());
        return "current-borrow";
    }

    @GetMapping("history-borrow")
    public String historyBorrow(){

        return null;
    }

    @GetMapping("reserve-book")
    public String reservationBook(){
        return "成功预定";
    }

    @GetMapping("return-book/{bookId}")
    @ResponseBody
    public String returnBook(@PathVariable("bookId")Long bookId,HttpServletRequest req){
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        return userService.returnBook(userId, bookId);
    }
















    @PostMapping("cascadetest")
    @ResponseBody
    public String cascadeTest(){

        //User user = userDao.findById("10014").orElse(null);

//        Set<Role> roles = user.getRoles();
//        System.out.println(roles);
//        roles.removeIf(role -> role.getRoleName().equals("admin"));
//        System.out.println(roles);
//        user.setRoles(roles);
        //只是用save方法不能成功更新数据，必须得 flush 一下
        //userDao.delete(user);
        return "删除角色成功";

    }


}
