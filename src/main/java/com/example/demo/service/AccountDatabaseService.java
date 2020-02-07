package com.example.demo.service;

import com.example.demo.domain.AccountDatabase;

public interface AccountDatabaseService {

    AccountDatabase findOneAccountRand();

    void insertAccount();
}
