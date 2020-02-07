package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserById(String userId);

    User findUserByUsername(String userName);

    List<User> findAllUser();

    void deleteUserRole(User user);

    void modUserRoleAndStatus(User user);

    void addUser(User user);

    String addBorrowingBook(String userId, Long bookId);

    List<Book> findCurrentBorrowBook(String userId);

    List<Book> findBorrowedBook(String userId);

    String returnBook(String userId, Long bookId);
}
