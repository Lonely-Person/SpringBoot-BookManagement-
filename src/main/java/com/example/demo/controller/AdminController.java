package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("allUser")
    public String userList(Model model) throws Exception{
        List<User> allUser = userService.findAllUser();
        model.addAttribute("allUser", allUser);
        return "user-list";
    }

    public String userDetail(){
        return null;
    }

    @GetMapping("modUserRoleAndStatus/{userName}")
    public String modUserRoleAndStatus(@PathVariable("userName")String userName, Model model){
        User user = userService.findUserByUsername(userName);
        List<Role> allRole = roleService.findAllRole();
        allRole.removeAll(user.getRoles()); //移除用户已有的角色
        model.addAttribute("user", user);
        model.addAttribute("allRole", allRole);
        return "modify-user-info";
    }

    @PostMapping("doModUserRoleAndStatus")
    @ResponseBody                       //注意如果使用Map接收form表单数据，必须使用@RequestParam，不能使用@RequestBody或者什么都不写
    public String doModUserRoleAndStatus(@RequestParam Map<String, String> userInfo){
        String userName = userInfo.get("userName");
        User user = userService.findUserByUsername(userName);

        String deleteRoleName = userInfo.get("deleteRole");
        Role deleteRole = roleService.findRoleByName(deleteRoleName);
        user.getRoles().remove(deleteRole);

        String addRoleName = userInfo.get("addRole");
        Role addRole = roleService.findRoleByName(addRoleName);
        user.getRoles().add(addRole);

        String userStatus = userInfo.get("userStatus");
        if (userStatus.equals("激活")){
            user.setUserStatus(1);
        }else{
            user.setUserStatus(0);
        }

        userService.modUserRoleAndStatus(user);
        return "修改成功";
    }

    public String addUser(){
        return null;
    }

    @GetMapping("addRole")
    public String addRole(Model model){
        List<Role> allRole = roleService.findAllRole();
        model.addAttribute("allRole", allRole);
        return "add-role";
    }

    @PostMapping("doAddRole")
    @ResponseBody
    public String doAddRole(@Validated Role role, BindingResult result){
        List<String> response = new ArrayList<>(); //这里存在性能问题
        if (result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getDefaultMessage());
                response.add(error.getDefaultMessage());
            }
            return response.toString();
        }
        return roleService.addRole(role);
    }
}
