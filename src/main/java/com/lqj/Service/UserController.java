//package com.lqj.Service;
//
//import com.lqj.DAO.UserDAO;
//import com.lqj.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/userService")
//public class UserController {
//
//    private UserDAO userDAO;
//
//    @Autowired
//    public UserController(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    //    @RequestMapping("/loginable.json")
////    public @ResponseBody Map<String, Object> loginable(@ModelAttribute("user") User user) {
//////        User au= (User) request.getAttribute("user");用forward时用
////        Map<String,Object> res=new HashMap<>();
////        System.out.println(user.toString());
////        User registerd_user= userDAO.loginable(user);
////        if (null!=registerd_user) {
////            res.put("logged", "success");
////            res.put("user", registerd_user);
////            return res;
////        } else {
////            res.put("logged", "fail");
////            return res;
//////            res.put("user", registerd_user);
////        }
////    }
////    改写为返回html的modelandview
////    @RequestMapping("/loginable")
////    public String loginable(@ModelAttribute("user") User user) {
//////        User au= (User) request.getAttribute("user");用forward时用
//////        Map<String,Object> res=new HashMap<>();
////        System.out.println(user);
////        System.out.println(1988);
////        User registerd_user = userDAO.loginable(user);
////
////        System.out.println(registerd_user);
////        if (null != registerd_user) {
//////            res.put("logged", "success");
//////            res.put("user", registerd_user);
//////            mav.addObject("user", "registerd_user888");
//////            mav.setViewName("hello");
//////            return mav;
//////            m.addAttribute("user", "user999999");
////            System.out.println(888);
////            return "hello";
//////            return mav;
////        } else {
////
////            return "hello";
////        }
////    }
//}
