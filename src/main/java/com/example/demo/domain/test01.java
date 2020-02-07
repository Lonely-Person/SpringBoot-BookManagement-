package com.example.demo.domain;

import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class test01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate future = LocalDate.of(2020, 1, 30);
        System.out.println(future);
        Period between = Period.between(future, now);
        int days = between.getDays();
        System.out.println(days);

        long until = now.until(future, ChronoUnit.DAYS);
        System.out.println(until);

    }
}
