package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class UserInfo implements Serializable {

    @Id
    private String infoId;

    private String phone;

    private String email;

    private Integer age;

    private LocalDate birth;

    private String address;

    private String school;

    private String eduBack;

    private String userMajor;


    //在这里维护关系，如果是多对一的话，一般在多的一方维护关系，添加关联时也在多的一方进行
    @OneToOne(targetEntity = User.class, cascade = {CascadeType.MERGE})
    //referencedColumnName是实体类中名称，如果使用@column制定了名称就是用指定的
    @JoinColumn(name = "info_user_id", referencedColumnName = "userId")
    private User user;

    //注意有关联关系的表进行查询时，toString()方法内不要在打印关联的对象了，不然会陷入无限循环
    @Override
    public String toString() {
        return "UserInfo{" +
                "infoId='" + infoId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", eduBack='" + eduBack + '\'' +
                ", userMajor='" + userMajor + '\'' +
                '}';
    }
}
