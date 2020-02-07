package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class User implements Serializable {

    @Id
    private String userId;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "用户名长度必须为3-20位")
    @Column(nullable = false, unique = true, length = 20)
    private String userName;

    @NotBlank(message = "邮箱不能为空")
    @Email(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "请输入合法的邮箱")
    @Column(nullable = false, unique = false, length = 20)
    private String userEmail;

    //这两个约束条件谁在上面没有影响，这里max会影响数据库中密码字段的长度，下面的@Column中的length将失效
    @Length(min = 6, max = 80, message = "密码长度必须为6-20位")
    @NotBlank(message = "密码不能为空")
    //因为要对密码进行MD5加密，长度跟实际输入长度不一致，所以不在这里设置密码长度限制
    @Column(nullable = false, length = 255)
    private String userPassword;

//    @NotBlank(message = "密码不能为空")
//    @Length(min = 6, max = 20, message = "密码长度必须为6-20位")
    @Column(nullable = false)
    @Transient
    private String userPasswordAgain;

    //因为设置默认值为1，所以添加insertable = false
    @Column(insertable = false, columnDefinition = "int default 1 comment '1:激活，0:冻结'")
    private Integer userStatus;

    //这个字段并不会在数据库内创建对应的字段，当然也不会创建外键
    //注意"user"是本类的首字母小写，不能任意
    //把维护关系的任务交给另一端
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserInfo userInfo;

    //在用户表中维护角色
    //PERSIST:给用户添加角色时，存在就成功添加，不存在的时候抛出异常（不会创建角色）
    //MERGE:当用会添加的角色存在时，添加成功，不存在时创建角色，删除用户时只会删除关系并不会删除角色
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
    private Set<Role> roles = new HashSet<>();

    private final static int borrowMaxNumbers = 10; //最大借阅本数

    @Column(insertable = false, columnDefinition = "int default 0 comment '当前借阅本数'")
    private Integer currentBorrowNumbers;
}
