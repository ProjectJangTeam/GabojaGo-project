package com.bitcamp.gabojago.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

    ServletContext sc;
    //MyPageService myPageService;


//    public MyPageController(ServletContext sc, MyPageService myPageService) {
//        this.sc = sc;
//        this.myPageService = myPageService;
//    }

    @GetMapping("/")
    public String myPage() {
        return "myPage/myPage";
    }

}

