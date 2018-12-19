package com.lqj.controller;

import com.lqj.DAO.TLDAO;
import com.lqj.entity.TaoLun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/taoLun")
public class TaoLunController {

    private int numNow;
    private TLDAO tldao;
    private int totalNumofTL;

    @RequestMapping("/getTaoLunList")
    public @ResponseBody List<TaoLun> getTaoLunList(@RequestParam("demand") String demand) {
        totalNumofTL = tldao.getTotalNums(tldao.getTlTable());
        List<TaoLun> tls;

        if ("newestFive".equals(demand)) {
            tls = tldao.getLatest(0, 5);
            System.out.println(tls);
            System.out.println("******");
            numNow = 0;
            return tls;
        } else if ("lastFive".equals(demand)) {
            if (numNow - 5 >= 0) {
                numNow -= 5;
            }
            tls = tldao.getLatest(numNow, 5);
            return tls;
        } else {
            if (numNow + 5 < totalNumofTL) {
                numNow += 5;
            }
            tls = tldao.getLatest(numNow, 5);
            return tls;
        }
    }

//    @RequestMapping("/showTLList")
//    public String showTLList(Model mav) {
//        System.out.println("*********show*********");
//        mav.addAttribute("tlList", tls);
//        System.out.println("跳转前");
//        System.out.println(tls);
//        System.out.println("准备跳转");
////        mav.("hello");
//        return "hello";
//    }

    public int getNumNow() {
        return numNow;
    }

    public void setNumNow(int numNow) {
        this.numNow = numNow;
    }

    public TLDAO getTldao() {
        return tldao;
    }

    @Autowired
    public void setTldao(TLDAO tldao) {
        this.tldao = tldao;
    }

    public int getTotalNumofTL() {
        return totalNumofTL;
    }

}
