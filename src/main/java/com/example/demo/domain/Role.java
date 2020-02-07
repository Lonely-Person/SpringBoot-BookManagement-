package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Role implements Serializable {

    @Id
    //主键采用数据库生成，IDENTITY：自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Length(min = 1, max = 15, message = "请输入1-15个字符之间的角色名")
    @Column(nullable = false, unique = true)
    private String roleName;

    //多对多中：被动的一方放弃维护权
    //mappedBy的 "roles"是根据另一方中的参数设置的
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
