package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.AccountDatabase;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.impl.AccountDatabaseServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class RegisterAndLogin {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AccountDatabaseServiceImpl accountService;

    @GetMapping("index")
    public String welcome(){
        return "index";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @PostMapping("doRegister")
    @ResponseBody
    public Map<String, String> doRegister(@Validated  User user, BindingResult result, Model model, HttpServletRequest request){
        Map<String,String> response = new HashMap<>();
        if (result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField()+"-"+error.getDefaultMessage());
                response.put(error.getField(), error.getDefaultMessage());
            }
            response.put("code", "100");

//            model.addAttribute(response);
            return response;
        }
        AccountDatabase userId = accountService.findOneAccountRand();
        Role role = new Role();
        //默认为游客角色
        role.setRoleId(1L);
        role.setRoleName("admin"); //注意Jpa先进行查询有没有这个角色，没有的话才创建，但是是根据Id进行查询的
        //为注册的用户创建一个类似于QQ的账号
        String accountId = userId.getAccountId();
        user.setUserId(accountId);
        user.getRoles().add(role);
        ByteSource salt = ByteSource.Util.bytes(user.getUserName());
        Md5Hash md5Hash = new Md5Hash(user.getUserPassword(), salt, 2);
        user.setUserPassword(md5Hash.toString());
        userService.addUser(user);

        HttpSession session = request.getSession();
        session.setAttribute("userName", user.getUserName());
        session.setAttribute("userId", user.getUserId());
//        model.addAttribute("code", "200");
        response.put("code", "200");
        return response;
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("doLogin")
    public String doLogin(HttpServletRequest request,
                          @RequestParam("userName") String username,
                          @RequestParam("userPassword")String password){
        System.out.println("进入此方法");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            //这个是与配置的shiro进行通信的
            subject.login(token);
            System.out.println("登陆成功");
        }catch (Exception e){
            System.out.println("登陆失败");
            return "login";
        }
        User user = userService.findUserByUsername(username);
        HttpSession session = request.getSession();
        session.setAttribute("userName", username);
        session.setAttribute("userId", user.getUserId());
        return "book-list";
    }
}
