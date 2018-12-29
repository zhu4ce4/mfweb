package com.lqj.controller;
//
//import com.lqj.DAO.UserDAO;
import com.lqj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
//
@Controller
public class LoginController {
//
//    private UserDAO userDAO;
//    private User logged_user;
//
//    public LoginController(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
    @RequestMapping("/login.html")
    public String index() {
        return "login";
    }
//
    @RequestMapping("/hello.html")
    public String hello() {
        return "hello";
    }
//
//    @RequestMapping(value = "/loginable", consumes = "application/json")
//    public @ResponseBody
//    String login(@RequestBody User user) {
//        logged_user = userDAO.findByNameAndPassword(user.getName(), user.getPassword());
//        return logged_user == null ? "no" : "yes";
//    }
////如果使用了RedirectAttributes作为参数，但是没有进行redirect，这种情况下不会将RedirectAttributes参数进行传递，默认还是传递forward对应的model，
//
//    @RequestMapping("/logged")
//    public ModelAndView login(ModelAndView mav, HttpSession session) {
////        todo:将user加入cookies
//        logged_user.setPassword("password");
//        session.setAttribute("user", logged_user);
//        mav.setViewName("redirect:hello.html");
//        return mav;
//    }
//
//    @GetMapping("/registerable")
//    @ResponseBody
//    public String registerable(@RequestParam("name") String name) {
//        User users = userDAO.findByName(name);
//        if (users == null) {
//            return "该昵称未被注册";
//        } else {
//            return "<a style='color:red'>该昵称已被注册，请重输！</a>";
//        }
//    }
//
//    @PostMapping("/register")
//    //此处不用@requestbody可以直接把file中的user相关属性解析出来,前提时file中的对应的name要与user的属性对应
//    public @ResponseBody
//    Map<String, Object> register(MultipartFile file, User user) throws IOException {
//        //todo:如果客户未上传头像,则使用默认头像
//        Map<String, Object> res = new HashMap<>();
//        User users = userDAO.findByName(user.getName());
//        if (users == null) {
//            User registered_user = userDAO.saveAndFlush(user);
//            String[] photo=file.getOriginalFilename().split("\\.");
//            String fileName = registered_user.getId() + "."+photo[photo.length-1];
//            registered_user.setPicpath(fileName);
//            userDAO.save(registered_user);
//            Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/img/userPhoto", File.separator, fileName);
//            file.transferTo(path);
//            res.put("registerd", "success");
//            res.put("user", registered_user);
//            return res;
//        } else {
//            res.put("registerd", "failed");
//            return res;
//        }
//    }
}
