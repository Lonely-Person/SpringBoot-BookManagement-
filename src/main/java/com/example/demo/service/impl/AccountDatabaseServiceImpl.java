package com.example.demo.service.impl;

import com.example.demo.dao.AccountDatabaseDao;
import com.example.demo.domain.AccountDatabase;
import com.example.demo.service.AccountDatabaseService;
import com.example.demo.util.AccountGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AccountDatabaseServiceImpl implements AccountDatabaseService {

    @Autowired
    AccountDatabaseDao accountDao;

    @Override
    @Transactional
    public AccountDatabase findOneAccountRand() {
        AccountDatabase account = accountDao.findRand();
        if (account == null){
            insertAccount();
        }
        account = accountDao.findRand();
        accountDao.delete(account);
        return account;
    }

    @Override
    @Transactional
    public void insertAccount() {
        AccountGenerator accountGenerator = new AccountGenerator();
        Set<String> strings = accountGenerator.accountGenerator();
        for (String string : strings) {
            accountDao.insertAccount(string);
        }
    }
}
