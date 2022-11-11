package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

    @GetMapping("/")
    public String myPage(HttpSession session, Model model) throws Exception {

        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember == null) {

            model.addAttribute("message", "로그인이 필요한 항목입니다. 회원가입 또는 로그인해 주세요.");

            return "myPage/myPageFail";

        } else {

            model.addAttribute("profileFig", loginMember.getProfileFig());
            model.addAttribute("nickname", loginMember.getNickName());
            model.addAttribute("mbti", loginMember.getMbti());

            return "myPage/myPage";

        }
    }
}

