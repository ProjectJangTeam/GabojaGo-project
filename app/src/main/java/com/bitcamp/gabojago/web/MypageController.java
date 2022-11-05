package com.bitcamp.gabojago.web;


import com.bitcamp.gabojago.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    ServletContext sc;
    NoticeService noticeService;


    public MypageController(NoticeService noticeService, ServletContext sc) {
        this.noticeService = noticeService;
        this.sc = sc;
    }

    @GetMapping("/")
    public String support() {
        return "mypage/mypage";
    }

}
