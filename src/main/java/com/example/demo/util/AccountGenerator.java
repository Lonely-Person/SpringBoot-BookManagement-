package com.example.demo.util;

import java.util.HashSet;
import java.util.Set;

public class AccountGenerator {

    private Set<String> account = new HashSet<>();;

    public Set<String> accountGenerator(){
        for (int i = 10000; i < 10100; i++) {
            account.add(String.valueOf(i));
        }
        return account;
    }
}
