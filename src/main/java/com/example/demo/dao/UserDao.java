package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User>{

    //Jpa提供的根据字段查询的方法有限
    //部分根据字段查询需要在这里声明
    User findByUserName(String username);

    //自定义jpql查询
    //@Query("from User where userName=?1")
    //String findByUserName(String username);


}
