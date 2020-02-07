package com.example.demo.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
public class AopLogEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @Column(columnDefinition = "char comment '访问者，为空则为游客'")
    String userName;  //访问者

    @Column(columnDefinition = "datetime comment '访问时间'")
    LocalDateTime visitTime;  //访问时间

    @Column(columnDefinition = "char comment '请求路径'")
    String reqUrl;   //请求路径

    @Column(columnDefinition = "char comment '请求类型：POST、GET'")
    String reqType;  //请求方法

    @Column(columnDefinition = "char comment '访问者IP'")
    String reqIp;    //访问者IP

    @Column(columnDefinition = "bigint comment '方法执行时间，毫秒'")
    Long interval;   //方法执行时间，毫秒
}
