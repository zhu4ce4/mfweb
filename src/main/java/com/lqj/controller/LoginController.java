package com.lqj.controller;

import com.lqj.DAO.UserDAO;
import com.lqj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private UserDAO userDAO;

    private User logged_user;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping("/login.html")
    public String index() {
        return "login";
    }

    @RequestMapping("/hello.html")
//    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/loginable", consumes = "application/json")
//    @RequestMapping(value = "/log")
    public @ResponseBody Map<String, Object> login(@RequestBody User user) {
//    public ModelAndView login(User user, ModelAndView mav) {
//    @ResponseBody
//    public ModelAndView login(ModelAndView m) {
//    public String login(@RequestBody User user, RedirectAttributes ra) {
        //转发给userservice里去进行登录验证
//        ModelAndView mv = new ModelAndView("forward:/userService/loginable");
//        mv.addObject("user", user);
//        return mv;
//        ra.addFlashAttribute("user", user);
//        mv.addObject("user", user);
//        mv.setViewName("forward:/userService/loginable");
//        return mv;
//        return "redirect:/userService/loginable.json";
//        return "redirect:/userService/loginable";
        //一个controller转发到另一个controller出现很多问题
//        return "forward:/userService/loginable";
//        System.out.println(user);

        Map<String, Object> res = new HashMap<>();
        logged_user = userDAO.loginable(user);
        if (null != logged_user) {
            System.out.println(0);
            res.put("loginable", "yes");
            System.out.println(1);
//        ModelAndView mav = new ModelAndView("hello");
//            mav.addObject("user", logged_user);
//            mav.addObject("user", "198804088733");
//            System.out.println(2);
//            mav.setViewName("hello");
//            System.out.println(3);
//            System.out.println(1);
            return res;
        } else {
            res.put("loginable", "no");
            return res;
        }
//        为何用forward不能传递参数ra？？？？
    }
//如果使用了RedirectAttributes作为参数，但是没有进行redirect，这种情况下不会将RedirectAttributes参数进行传递，默认还是传递forward对应的model，

    @RequestMapping("/logged")
    public ModelAndView login(ModelAndView mav) {
        mav.addObject("user", logged_user);
        mav.setViewName("hello");
        return mav;
    }

    @GetMapping("/registerable")
    @ResponseBody
    public String registerable(@RequestParam("name") String name) {
        if (userDAO.registerable(name)) {
            return "该昵称未被注册";
        } else {
            return "该昵称已被注册";
        }
    }

    @PostMapping("/register")
    //此处不用@requestbody可以直接把file中的user相关属性解析出来,前提时file中的对应的name要与user的属性对应
    public @ResponseBody
    Map<String, Object> register(MultipartFile file, User user) throws IOException {

        Map<String, Object> res = new HashMap<>();
        if (userDAO.registerable(user.getName())) {
            User registered_user = userDAO.add(user, file);
            res.put("registerd", "success");
            res.put("user", registered_user);
            return res;
        } else {
            res.put("registerd", "failed");
            return res;
        }
    }

    @GetMapping("/getonlineNumber")
    public int getOnlineNumber() {
        return 0;
    }

    @PostMapping("/addTaoLun")
    public int addTaoLun() {
        return 0;
    }

//    public UserDAO getUserDAO() {
//        return userDAO;
//    }

    public User getLogged_user() {
        return logged_user;
    }

//    @Autowired
//    public void setLogged_user(User logged_user) {
//        this.logged_user = logged_user;
//    }
    //    @RequestMapping("/hello")
//    public String hello(Model m) {
//        m.addAttribute("user", "198848");
//        return "hello";
//    }
}
