package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.ModifyMyPageService;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/myPage/modify/")
public class ModifyMyPageController {

    private ServletContext sc;

    private ModifyMyPageService modifyMyPageService;

    public ModifyMyPageController(ServletContext sc, ModifyMyPageService modifyMyPageService) {
        this.sc = sc;
        this.modifyMyPageService = modifyMyPageService;
    }

    @GetMapping("profileDetail")
    public Map profileDetail(HttpSession session) throws Exception {
        Member loginMember = (Member) session.getAttribute("loginMember");
        Member member = modifyMyPageService.get(loginMember.getId());

        Map map = new HashMap();
        map.put("member", member);
        return map;
    }

    @GetMapping("myAccountDetail")
    public Map myAccountDetail(HttpSession session) throws Exception {
        Member loginMember = (Member) session.getAttribute("loginMember");
        Member member = modifyMyPageService.get(loginMember.getId());

        Map map = new HashMap();
        map.put("member", member);
        return map;
    }

    @PostMapping("profileUpdate")
    public String profileUpdate(
            Member member,
            @RequestParam MultipartFile file,
            HttpSession session) throws Exception {

           String dirPath = sc.getRealPath("/board/files");
           String filename = UUID.randomUUID().toString();
           String profileFig = filename;
           file.transferTo(new File(dirPath + "/" + filename));

           member.setProfileFig(profileFig);

           modifyMyPageService.profileUpdate(member);

           return "redirect:/myPage/";
    }

    @PostMapping ("myAccountUpdate")
    public String myAccountUpdate(Member member, HttpSession session) throws Exception {
        modifyMyPageService.myAccountUpdate(member);
        return "redirect:/myPage/";
    }

}

