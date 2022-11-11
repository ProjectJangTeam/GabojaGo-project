package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.QnaService;
import com.bitcamp.gabojago.vo.qna.QnaBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/support/qna/")
public class QnaController {
    @Autowired
    QnaService qnaService;

    public QnaController(QnaService qnaService) {
        System.out.println("QnaController() 호출됨!");
        this.qnaService = qnaService;
    }

    @GetMapping("list")
    public void list(Model model) throws Exception {
        model.addAttribute("qnaBoards", qnaService.list());
    }

    @GetMapping("addForm")
    public void addForm() throws Exception {

    }

    @PostMapping("add")
    public String add(
            QnaBoard qnaBoard,
            HttpSession session) throws Exception {
        System.out.println("qnaControllerAdd : " + qnaBoard.toString());
        qnaBoard.setId("user1"); // 로그인전 테스트 위해 임의로 넣은 값
        qnaService.add(qnaBoard);
        return "redirect:list";
    }

    @GetMapping("detail")
    public void detail(int no, Model model) throws Exception {
        model.addAttribute("qnaBoard", qnaService.get(no));
    }

    @GetMapping("delete")
    public String delete(int no) throws Exception {
        qnaService.delete(no);
        return "redirect:list";
    }

    @GetMapping("editForm")
    public void editForm(int no, Model model) throws Exception {
        model.addAttribute("qnaBoard", qnaService.get(no));
    }

    @PostMapping("update")
    public String update(
            QnaBoard qnaBoard,
            HttpSession session) throws Exception {
        System.out.println("qnaControllerUpdate : " + qnaBoard.toString());
        qnaBoard.setId("user1"); // 로그인전 테스트 위해 임의로 넣은 값
        qnaService.update(qnaBoard);
        return "redirect:list";
    }
}
