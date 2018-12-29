//package com.lqj.controller;
//
////import com.lqj.DAO.CriticsDAO;
//import com.lqj.entity.Critics;
//import com.lqj.entity.User;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Controller
//@RequestMapping("/critic")
//public class CriticController {
//
//    private int pageNow;
//    private CriticsDAO criticsDAO;
//
//    public CriticController(CriticsDAO criticsDAO) {
//        this.criticsDAO = criticsDAO;
//    }
//
//    @RequestMapping("/getCriticList")
//    public @ResponseBody
//    List<Critics> getCriticList(@RequestParam("demand") String demand, @RequestParam("tlid") int tlid) {
//        List<Critics> critics= criticsDAO.findByTlid(tlid);
//        long totalNumofCT = critics.size();
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        if ("newestFive".equals(demand)) {
//            pageNow = 0;
//        } else if ("lastFive".equals(demand)) {
//            if (pageNow - 1 >= 0)
//                pageNow--;
//        } else {
//            if (pageNow + 1 < totalNumofCT/ 5.0) {
//                pageNow++;
//            }
//        }
//        Pageable pageable = PageRequest.of(pageNow, 5, sort);
//        return criticsDAO.findByTlid(tlid, pageable);
//    }
//
//    @RequestMapping(value = "/addCritics", consumes = "application/json")
//    public @ResponseBody
//    String addCritics(@RequestBody Critics ct, HttpSession session) {
//        //检查是否登录,也即session里面是否有user
//        User user = (User) session.getAttribute("user");
//        if (null == user) {
//            return "unlogged";
//        }
//        ct.setCriticName(user.getName());
//        if (null!=criticsDAO.saveAndFlush(ct)) {
//            return "sucess";
//        } else {
//            return "failed";
//        }
//    }
//}
