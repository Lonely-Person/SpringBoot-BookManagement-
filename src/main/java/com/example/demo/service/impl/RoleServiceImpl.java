package com.example.demo.service.impl;

import com.example.demo.dao.RoleDao;
import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleDao.findRoleByRoleName(roleName);
    }

    @Override
    @Transactional
    public String addRole(Role role) {
        List<Role> allRole = findAllRole();
        for (Role r : allRole) {
            if (role.getRoleName().equals(r.getRoleName())){
                return "角色已存在，请重新输入";
            }
        }
        roleDao.save(role);
        return "成功创建角色";
    }
}
