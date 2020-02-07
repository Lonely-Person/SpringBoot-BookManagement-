package com.example.demo.service;

import com.example.demo.domain.Borrow;

import java.util.List;

public interface BorrowService {

    void save(Borrow borrow);

    List<Long> findCurrentBorrowByUserId(String userId);
}
