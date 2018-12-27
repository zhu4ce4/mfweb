package com.lqj.controller;

import com.lqj.DAO.TLDAO;
import com.lqj.entity.TaoLun;
import com.lqj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/taoLun")
public class TaoLunController {

    private int pageNow;
    private TLDAO tldao;

    @RequestMapping("/getTaoLunList")
    public @ResponseBody
    List<TaoLun> getTaoLunList(@RequestParam("demand") String demand) {
        long totalNumOfTL = tldao.count();

        Sort sort = new Sort(Sort.Direction.DESC, "id");

        if ("newestFive".equals(demand)) {
            pageNow = 0;

        } else if ("lastFive".equals(demand)) {
            if (pageNow - 1 >= 0)
                pageNow --;
        } else {
            if (pageNow + 1 < totalNumOfTL / 5.0) {
                pageNow ++;
            }
        }
        Pageable pageable = PageRequest.of(pageNow, 5, sort);
        Page<TaoLun> page = tldao.findAll(pageable);
        return page.getContent();
    }

    @RequestMapping(value = "/addTaoLun", consumes = "application/json")
    @ResponseBody
    public String addTaoLun(@RequestBody TaoLun taolun, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            return "unlogged";
        }
        taolun.setAuthor(user.getName());
        return ""+tldao.saveAndFlush(taolun);
    }

    @RequestMapping("/tlContent/{id}")
    public ModelAndView tlContent(@PathVariable("id") int id, ModelAndView mav) {
        TaoLun tl = tldao.getOne(id);
        mav.addObject("taolun", tl);
        mav.setViewName("tlContent");
        return mav;
    }

    public TLDAO getTldao() {
        return tldao;
    }

    @Autowired
    public void setTldao(TLDAO tldao) {
        this.tldao = tldao;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }
}
