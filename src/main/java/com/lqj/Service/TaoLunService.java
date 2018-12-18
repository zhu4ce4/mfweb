package com.lqj.Service;

import com.lqj.DAO.TLDAO;
import com.lqj.entity.TaoLun;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TaoLunService {


    //    private TaoLun taoLun;


    @PostMapping("/addTaoLun")
    public TaoLun prepareTaoLun() {
        int id = new TLDAO().nextId();
        //接收网页提交的参数,并检验内容是否内容或长度合法，后redirect 去/addTaoLunInDAO去进行实际的增加
        return null;
    }

}
