package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Student implements Serializable {

    @Id
    private String stuId;  //注意字符串的id不支持自增长

    @Column(unique = true, nullable = false)
    private String stuName;

    @Column(nullable = false)
    private String stuPassword;

    //tinyint(1)中指定的位数是说，当前面填充0时，显示几个0.但并不影响其所占的字节数以及所能表达数值的大小
    @Column(nullable = false, columnDefinition = "tinyint(1) comment '性别 0:男 1:女'")
    private byte stuSex;

    @Column(nullable = false)
    private short stuAge;


    @Column(nullable = false)
    private LocalDate stuGrade;

    @Column(nullable = false, length = 1)
    //byte对应数据库中默认为 tinyint(4)
    private byte stuStatus;

}
