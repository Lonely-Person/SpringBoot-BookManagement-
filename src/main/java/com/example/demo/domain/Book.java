package com.example.demo.domain;


import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false, columnDefinition = "varchar(256) comment '书名'")
    private String bookName;

    @Column(nullable = false, columnDefinition = "varchar(256) comment '作者'")
    private String bookAuthor;

    @Column(nullable = false, columnDefinition = "varchar(256) comment '出版社'")
    private String bookPublisher;

    @Column(nullable = false, columnDefinition = "date comment '图书发布日期'")
    private LocalDate bookPubDate;

    @Column(nullable = false, insertable = false, columnDefinition = "int default 1 comment '1:允许外接，0:不许外接'")
    private Integer bookStatus;

    @Column(insertable = false, columnDefinition = "int default 2 comment '图书数量'")
    private Integer bookNumbers;

    @Column(insertable = false, columnDefinition = "int default 2 comment '图书剩余数量'")
    private Integer remainNumbers;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = BookCategory.class)
    @JoinColumn(name = "book_category_name", referencedColumnName = "categoryName")
    private BookCategory bookCategoryName;

    //columnDefinition前面必须先指定类型，才能添加注释，直接添加注释会出错
    @Column(nullable = true, columnDefinition = "date comment '登记日期'")
    private LocalDate bookRecord;

    public Long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public LocalDate getBookRecord() {
        return bookRecord;
    }

    public String getBookCategoryName() {
        return bookCategoryName.getCategoryName();
    }

    public LocalDate getBookPubDate() {
        return bookPubDate;
    }

    public Integer getBookNumbers() {
        return bookNumbers;
    }

    public Integer getRemainNumbers() {
        return remainNumbers;
    }
}
