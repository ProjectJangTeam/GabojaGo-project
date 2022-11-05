package com.bitcamp.gabojago.web;


import com.bitcamp.gabojago.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    ServletContext sc;
    //MyPageService myPageService;


//    public MyPageController(ServletContext sc, MyPageService myPageService) {
//        this.sc = sc;
//        this.myPageService = myPageService;
//    }



    @GetMapping("/")
    public String myPage() {
        return "mypage/mypage";
    }

}
