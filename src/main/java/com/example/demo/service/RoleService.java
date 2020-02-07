package com.example.demo.service;

import com.example.demo.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    Role findRoleByName(String roleName);

    String addRole(Role role);
}
