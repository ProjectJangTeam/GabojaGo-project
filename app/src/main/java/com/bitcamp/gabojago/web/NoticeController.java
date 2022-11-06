package com.bitcamp.gabojago.web;


import com.bitcamp.gabojago.service.NoticeService;
import com.bitcamp.gabojago.vo.Notice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/support")
public class NoticeController {

    ServletContext sc;
    NoticeService noticeService;



    public NoticeController(NoticeService noticeService, ServletContext sc) {
        this.noticeService = noticeService;
        this.sc = sc;
    }

    @GetMapping("/")
    public String support() {
        return "support/support";
    }

    @GetMapping("/noticeForm")
    public String noticeForm(Notice notice) {
        return "/support/noticeForm";
    }


    @PostMapping("/noticeAdd")
    public String noticeAdd(Notice notice, HttpSession session) throws Exception {
        noticeService.noticeAdd(notice);
        return "redirect:/support/noticeList";
    }

    @GetMapping("/noticeList")
    public void noticeList(Model model) throws Exception {
        model.addAttribute("notices", noticeService.noticeList());
    }

    @GetMapping("/noticeDetail")
    public Map noticeDetail(int no) throws Exception {
        Notice notice = noticeService.get(no);
        if (notice == null) {
            throw new Exception("해당 번호의 게시글이 없습니다!");
        }

        Map map = new HashMap();
        map.put("notice", notice);
        return map;

    }
}
