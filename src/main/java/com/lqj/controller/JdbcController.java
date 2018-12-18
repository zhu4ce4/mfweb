//package com.lqj.controller;
//
//import com.lqj.DAO.UserDAO;
//import com.lqj.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class JdbcController {
//    private final UserDAO userdao;
//
//    @Autowired
//    public JdbcController(UserDAO userdao) {
//        this.userdao = userdao;
//    }
//
//    @GetMapping
//    public List<User> queryUsers() {
//        return userdao.list();
//    }
//
//    @GetMapping("/{id}")
//    public User getUser(@PathVariable int id) {
//        return userdao.getAuser(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public int delUser(@PathVariable int id) {
//        return userdao.delete(id);
//    }
//
//    @PostMapping()
//    public int addUser(@RequestBody User user) {
//        int nextid = userdao.nextId();
//        return userdao.add(user,nextid);
//    }
//
//    //todo:待处理
////    @PutMapping("/{name}")
////    public int editUser(@PathVariable String name,@RequestBody User user) {
////        return UserDAO.update(user, user.getName(), name);
////    }
//
//}
