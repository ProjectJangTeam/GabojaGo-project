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
@RequestMapping("/support/notice/")
public class NoticeController {

    ServletContext sc;
    NoticeService noticeService;



    public NoticeController(NoticeService noticeService, ServletContext sc) {
        this.noticeService = noticeService;
        this.sc = sc;
    }


    @GetMapping("noticeForm")
    public void noticeForm() throws Exception { }


    @PostMapping("noticeAdd")
    public String noticeAdd(Notice notice, HttpSession session) throws Exception {
        noticeService.noticeAdd(notice);
        return "redirect:noticeList";
    }

    @GetMapping("noticeList")
    public void noticeList(Model model) throws Exception {
        model.addAttribute("notices", noticeService.noticeList());
    }

    @GetMapping("noticeDetail")
    public Map noticeDetail(int no) throws Exception {
        Notice notice = noticeService.get(no);
        if (notice == null) {
            throw new Exception("해당 번호의 게시글이 없습니다!");
        }

        Map map = new HashMap();
        map.put("notice", notice);
        return map;

    }

    @GetMapping("noticeEditDetail")
    public Map noticeEditDetail(int no) throws Exception {
        Notice notice = noticeService.getEdit(no);
        if (notice == null) {
            throw new Exception("해당 번호의 게시글이 없습니다!");
        }

        Map map = new HashMap();
        map.put("notice", notice);
        return map;

    }

    @PostMapping ("noticeEditUpdate")
    public String noticeEditUpdate(Notice notice, HttpSession session) throws Exception {
        noticeService.noticeEditUpdate(notice);
        return "redirect:noticeList";
    }

    @GetMapping("noticeDelete")
    public String noticeDelete(int no, HttpSession session) throws Exception {
        noticeService.noticeDelete(no);
        return "redirect:noticeList";
    }
}
