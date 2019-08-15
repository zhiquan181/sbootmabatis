package com.zhiquan.cai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiquan.cai.model.User;
import com.zhiquan.cai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
//@ResponseBody
//RestController返回的不是页面,Controller返回的是页面  RestController=Controller + ResponseBody
@RequestMapping("/home")
public class UserController {
    @Autowired
    private UserService userService;

    //根据id显示该用户
    @RequestMapping("/showUser/{id}")
    public String selectUser (@PathVariable int id,Model model){
        User user = new User();
        user = userService.selectUser(id);
        model.addAttribute("user",user);
        return "showUser";
    }

    //显示所有用户
    @RequestMapping("/showUsers")
    public String showUser(Model model){
        //model.addAttribute("users", userService.selectAllUser().toString());//字符串变量
        List<User> userList = userService.selectAllUser();
        model.addAttribute(userList);
        return "showUsers";
    }

    //go to 新增用户页面
    @RequestMapping("/ToinsertUser")
    public String ToinsertUser() {
        return "insertUser";
    }

    //新增用户
    @RequestMapping("/insertUser")
    public String insertUser(Model model,HttpServletRequest request) {
        System.out.println("--执行insertUser方法--");
        String username = request.getParameter("account");
        String password = request.getParameter("passwd");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("--"+username+"--"+password+"--"+age+"--");
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setAge(age);
        try {
            int status = userService.insertUser(u);
            System.out.println("--insertUser success--"+status+"--");
        }catch (Exception e){
            System.out.println("--insertUser error--");
        }
        finally {
            return "redirect:/home/showUsers";//重定向到用户列表
        }
    }

    //go to 修改用户页面
    @RequestMapping("/ToupdateUser")
    public String ToupdateUser(Model model,HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("--"+id+"--");
        User user = new User();
        user = userService.selectUser(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    //修改用户
    @RequestMapping("/updateUser")
    public String updateUser(Model model,HttpServletRequest request) {
        System.out.println("--执行updateUser方法--");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("account");
        String password = request.getParameter("passwd");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("--"+id+"--"+username+"--"+password+"--"+age+"--");
        User u = new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(password);
        u.setAge(age);
        try {
            int status = userService.updateUser(u);
            System.out.println("--updateUser success--"+status+"--");
        }catch (Exception e){
            System.out.println("--updateUser error--");
        }
        finally {
            return "redirect:/home/showUsers";//重定向到用户列表
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            int status = userService.deleteUser(id);
            System.out.println("--deleteUser success--"+status+"--");
        }catch (Exception e){
            System.out.println("--deleteUser error--");
        }
        finally {
            return "redirect:/home/showUsers";//重定向到用户列表
        }
    }

    @GetMapping("/users")
    public PageInfo<User> lists(@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "3") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.getUsers());
        return pageInfo;
    }

//    @GetMapping("/users")
//    public List<User> lists(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize) {
//        PageHelper.startPage(pageNo,pageSize);
//        return userService.getUsers();
//    }






}