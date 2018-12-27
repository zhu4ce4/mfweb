package com.lqj.controller;

import com.lqj.DAO.TLDAO;
import com.lqj.entity.TaoLun;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("userProfile")
@RequestMapping("/userProfile")
public class UserController {

    private TLDAO tldao;
    private int pageNow;

    public UserController(TLDAO tldao) {
        this.tldao = tldao;
    }

    @GetMapping("")
    public String userProfile() {
        return "userProfile.html";
    }

    @RequestMapping("/getTaoLunList")
    public @ResponseBody
    List<TaoLun> getTaoLunList(@RequestParam("demand") String demand, @RequestParam("author") String author) {
        List<TaoLun> tls = tldao.findByAuthor(author);
        long totalNumOfTL = tls.size();
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        if ("newestFive".equals(demand)) {
            pageNow = 0;
        } else if ("lastFive".equals(demand)) {
            if (pageNow - 1 >= 0)
                pageNow--;
        } else {
            if (pageNow + 1 < totalNumOfTL / 5.0) {
                pageNow++;
            }
        }
        Pageable pageable = PageRequest.of(pageNow, 5, sort);
        return tldao.findByAuthor(author, pageable);
    }
}
