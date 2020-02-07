package com.example.demo.service.impl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BorrowDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Book;
import com.example.demo.domain.Borrow;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    BorrowDao borrowDao;

    @Override
    public User findUserById(String userId) {
        return userDao.getOne(userId);
    }

    @Override
    public User findUserByUsername(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void deleteUserRole(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public void modUserRoleAndStatus(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public String addBorrowingBook(String userId, Long bookId) {
        List<Long> userBorrowedBook = borrowDao.findCurrentBorrowByUserId(userId);
        for (Long aLong : userBorrowedBook) {
            if (aLong == bookId){
                return "你已经借阅了本书，请勿重复借阅";
            }
        }
        Book book = bookDao.getOne(bookId);
        int remainNumbers = book.getRemainNumbers()-1;
        book.setRemainNumbers(remainNumbers);
        bookDao.saveAndFlush(book);

        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBookId(bookId);
        borrow.setBorrowDate(LocalDate.now());
        borrow.setExpectReturnDate(LocalDate.now().plusMonths(6));
        borrowDao.save(borrow);

        User user = userDao.getOne(userId);
        user.setCurrentBorrowNumbers(user.getCurrentBorrowNumbers()+1);

        bookDao.saveAndFlush(book);
        userDao.saveAndFlush(user);
        borrowDao.save(borrow);
        return "借阅成功";
    }

    @Override
    public List<Book> findCurrentBorrowBook(String userId) {
        List<Long> booksId = borrowDao.findCurrentBorrowByUserId(userId);
        List<Book> books = new ArrayList();
        for (Long bookId : booksId) {
            books.add(bookDao.getOne(bookId));
        }
        return books;
    }

    @Override
    public List<Book> findBorrowedBook(String UserId) {
        return null;
    }

    @Override
    @Transactional
    public String returnBook(String userId, Long bookId) {
        Borrow borrow = borrowDao.findBorrowByUserIdAndBookId(userId, bookId);
        byte status = borrow.getReturned();
        if ((byte) 1==status){
            return "已经归还，请勿重复操作";
        }

        LocalDate expectReturnDate = borrow.getExpectReturnDate();
        LocalDate returnDate = LocalDate.now();
        borrow.setReturnDate(returnDate);
        long overDays = ChronoUnit.DAYS.between(expectReturnDate, returnDate);
        if (overDays>0){
            borrow.setTicket((int)overDays);
            borrow.setOverDay((int)overDays);
        }else {
            borrow.setTicket(0);
            borrow.setOverDay(0);
        }
        borrow.setReturned((byte)1);
        borrowDao.saveAndFlush(borrow);

        Book book = bookDao.getOne(bookId);
        book.setRemainNumbers(book.getRemainNumbers()+1);
        bookDao.saveAndFlush(book);

        User user = userDao.getOne(userId);
        user.setCurrentBorrowNumbers(user.getCurrentBorrowNumbers()-1);
        userDao.saveAndFlush(user);

        return "归还成功";
    }


}
