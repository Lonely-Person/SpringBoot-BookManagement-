package com.example.demo.service.impl;

import com.example.demo.dao.BorrowDao;
import com.example.demo.domain.Borrow;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowDao borrowDao;

    @Override
    public void save(Borrow borrow) {
        borrowDao.save(borrow);
    }

    @Override
    public List<Long> findCurrentBorrowByUserId(String userId) {
        return borrowDao.findCurrentBorrowByUserId(userId);
    }
}
