package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Borrow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowId;

    //设置过多外键既不利于对字段的操作，而且也会导致数据库的插入性能下降
    //@JsonIgnore
    //@ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
    //referencedColumnName = "userId",这个要么不设置（默认是Id），要么设置成Id，不接受其他字段
    //@JoinColumn(name = "borrow_user")  //把这行代码注释掉，数据库中依然会保存这个字段，只不过按照自己的意愿来起名字罢了
    @Column(nullable = true)
    private String userId;

    //@JsonIgnore
    //@OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    //@JoinColumn(name = "borrow_book")
    @Column(nullable = true)
    private Long bookId;

    @Column(nullable = false, columnDefinition = "date comment '借出时间'")
    private LocalDate borrowDate;

    @Column(nullable = false, columnDefinition = "date comment '预期归还时间'")
    private LocalDate expectReturnDate;

    @Column(columnDefinition = "date comment '实际归还时间'")
    private LocalDate returnDate;

    @Column(columnDefinition = "int default 0 comment '逾期天数'")
    private Integer overDay;

    @Column(columnDefinition = "int default 0 comment '罚款金额'")
    private Integer ticket;

    @Column(columnDefinition = "tinyint default 0 comment '0:未归还；1:已归还'")
    private byte returned;

    

}
