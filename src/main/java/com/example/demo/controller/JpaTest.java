package com.example.demo.controller;

import com.example.demo.dao.AccountDatabaseDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.domain.AccountDatabase;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.AccountDatabaseServiceImpl;
import com.example.demo.util.AccountGenerator;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class JpaTest {

    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Autowired
    AccountDatabaseDao accountDao;

    @Autowired
    AccountDatabaseServiceImpl accountService;

    @GetMapping("121")
    @Transactional
    public String oneToOne(){
//        UserInfo userInfo = userInfoDao.getOne("2001");
//        User user = userInfo.getUser();
//        System.out.println(user);
        User one = userDao.getOne("1007");
        UserInfo userInfo = one.getUserInfo();
        System.out.println(userInfo);
        return userInfo.toString();
    }

    @GetMapping("m2m")
    @Transactional
    public String manyToMany(){

        Role role = new Role();
        role.setRoleName("super01");

        User user = new User();
        user.setUserId("1008");
        user.setUserName("李欣01");
        user.setUserPassword("1234");

        user.getRoles().add(role);

        //roleDao.save(role); 这条语句可以可加可不加，都不会报错，执行的语句也不变，不知道为什么
        userDao.save(user);


        return "添加角色成功";
    }

    @GetMapping("m2mq")
    public String manyToManyQuery(){
        //不建议使用getOne()，当数据不存在时，就会报错，findById().orElse(null)可以处理不存在时返回null
        //或者是使用findById().isPresent()可以进行判断，不存在的时候进行处理
        User one = userDao.getOne("1007");
        Set<Role> roles = one.getRoles();

        return roles.toString();
    }

    @GetMapping("querynotnull")
    public String queryTest(){

        System.out.println(userDao.findByUserName("5555"));
        return "one.toString()";
    }

    @GetMapping("createaccount")
    @Transactional  //当执行添加或者更新操作时，要加上事务
    public String createAccount(){
        AccountGenerator accountGenerator = new AccountGenerator();
        Set<String> strings = accountGenerator.accountGenerator();
        for (String string : strings) {
            accountDao.insertAccount(string);
        }
        System.out.println(strings.size());
        return "创建了10000个账户";
    }

    @GetMapping("randgetaccount")
    public String randAccount(){
        AccountDatabase rand = accountService.findOneAccountRand();

        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return rand.toString();
    }

}
