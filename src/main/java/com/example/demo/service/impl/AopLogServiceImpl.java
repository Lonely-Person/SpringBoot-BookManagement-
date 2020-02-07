package com.example.demo.service.impl;

import com.example.demo.dao.AopLogDao;
import com.example.demo.domain.AopLogEntity;
import com.example.demo.service.AopLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AopLogServiceImpl implements AopLogService {

    @Autowired
    AopLogDao aopLogDao;

    @Override
    public void insertLog(AopLogEntity log) {
        aopLogDao.save(log);
    }
}
