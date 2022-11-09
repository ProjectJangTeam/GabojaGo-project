package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.MemberService;
import com.bitcamp.gabojago.service.ProfileService;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/myPage/modify/")
public class ProfileController {

    private MemberService memberService;
    private ServletContext sc;

    private ProfileService profileService;

    public ProfileController(ProfileService profileService, ServletContext sc) {
        this.profileService = profileService;
        this.sc = sc;
    }

    @GetMapping("profileDetail")
    public Map profileDetail(HttpSession session) throws Exception {
        Member loginMember = (Member) session.getAttribute("loginMember");
        Member member = profileService.get(loginMember.getId());

        Map map = new HashMap();
        map.put("member", member);
        return map;
    }

//    @PostMapping("profileUpdate")
//    public String profileUpdate(
//            Member member,
//            Part[] files,
//            HttpSession session) throws Exception {
//
//    }





}

