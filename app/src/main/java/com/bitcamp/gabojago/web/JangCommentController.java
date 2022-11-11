//package com.bitcamp.gabojago.web;
//
//import com.bitcamp.gabojago.service.ExhibitionReviewService;
//import com.bitcamp.gabojago.service.JangCommentService;
//import com.bitcamp.gabojago.vo.ExhibitionReview;
//import com.bitcamp.gabojago.vo.JangComment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Controller // 주소 전달
//@RequestMapping("/jang-comment/")
//public class JangCommentController {
//
//@Autowired
//JangCommentService jangCommentService;
//
//  @ResponseBody  //데이터 전달 빠르게 확인 가능
//  @RequestMapping("comment-select-list/{recono}")
//  public List<JangComment> jangCommentList(@PathVariable("recono") int recono, Model model) throws Exception{
//    return jangCommentService.jangCommentList(recono);
//  }
//
//  @PostMapping("jangCommentAdd")
//  public String jangCommentInsert(JangComment jangComment,
//                                  HttpSession session) throws Exception {
//    jangCommentService.jangCommentInsert(jangComment);
//    return "redirect:../recommendation/detail?recono="+jangComment.getRecono();
//  }
//
//  @GetMapping("jangCommentDelete")
//  public String jangCommentDelete(int cmno, HttpSession session, ExhibitionReview exhibitionReview) throws Exception {
//    //  checkOwner(no, session);
//    if(!jangCommentService.jangCommentDelete(cmno)) {
//      throw new Exception("댓글을 삭제 할 수 없습니다.");
//    }
//
//    return "redirect:../recommendation/recommendationList";
//  }
//
//  @PostMapping("update")
//  public String update(JangComment jangComment, HttpSession session) throws Exception{
//
////  checkOwner(board.getNo(), session);
//
//    if(!jangCommentService.jangCommentUpdate(jangComment)){
//      throw new Exception("댓글을 변경 할 수 없습니다!");
//    }
//    return "redirect:../recommendation/recommendationList";
//  }
//
//
//
//
//}
