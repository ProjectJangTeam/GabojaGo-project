package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Member;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;

import com.bitcamp.gabojago.service.RecommendationService;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.Recommendation;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/recommendation/")
public class RecommendationController {
  @Autowired
  ServletContext sc;
  @Autowired
  RecommendationService recommendationService;

  public RecommendationController() {
    System.out.println("RecommendationController() 호출됨!");
  }

  // InternalResourceViewResolver 사용 후:
  @GetMapping("jangSoReviewForm")
  public void form() throws Exception {
  }

  @Transactional
  @PostMapping("recommendationAdd")
  public String add(@RequestParam("files") MultipartFile[] files, HttpSession session,
           Recommendation recommendation, JangSoReview[] jangSoReviews) throws Exception {

    recommendation.setWriter((Member) session.getAttribute("loginMember"));

    int n = 3; //tr 갯수
    //TODO
    List<JangSoReview> Reviews = new ArrayList<>();

    for (JangSoReview jangSoReview : jangSoReviews) {
      
    }




    recommendationService.recommendationAdd(recommendation);

    for(int i = 0; i < n; i ++)
      recommendationService.jangSoReviewAdd(jangSoReviews[i]);

    return "redirect:recommendationList";
  }

  // 민구작성메서드
  private List<JangSoReviewAttachedFile> saveJangSoReviewAttachedFiles(MultipartFile[] files)
      throws Exception {

  List<JangSoReviewAttachedFile> jangSoReviewAttachedFiles = new ArrayList<>();
  String dirPath = sc.getRealPath("/board/files");

    for (MultipartFile file : files) {
    if (file.isEmpty()) {
      continue;
    }

    String filename = UUID.randomUUID().toString();
    file.transferTo(new File(dirPath + "/" + filename));
      jangSoReviewAttachedFiles.add(new JangSoReviewAttachedFile(filename));
  }
    return jangSoReviewAttachedFiles;
  }


  // 민구작성메서드
  @GetMapping("disableRecommend")
  public String disableRecommend(int recono) throws Exception {
    if (!recommendationService.disableRecommend(recono)) {
      throw new Exception("코스추천글 삭제 실패");
    }

    return "redirect:recommendationList";
  }

//  private List<JangSoReviewAttachedFile> saveAttachedFiles(Part[] files)
//      throws IOException, ServletException {
//    List<JangSoReviewAttachedFile> attachedFiles = new ArrayList<>();
//    String dirPath = sc.getRealPath("/jangSoReview/files");
//
//    for (Part part : files) {
//      if (part.getSize() == 0) {
//        continue;
//      }
//
//      String filename = UUID.randomUUID().toString();
//      part.write(dirPath + "/" + filename);
//      attachedFiles.add(new JangSoReviewAttachedFile(filename));
//    }
//    return attachedFiles;
//  }
//
//  private List<JangSoReviewAttachedFile> saveAttachedFiles(MultipartFile[] files)
//      throws IOException, ServletException {
//    List<JangSoReviewAttachedFile> attachedFiles = new ArrayList<>();
//    String dirPath = sc.getRealPath("/jangSoReview/files");
//
//    for (MultipartFile part : files) {
//      if (part.isEmpty()) {
//        continue;
//      }
//
//      String filename = UUID.randomUUID().toString();
//      part.transferTo(new File(dirPath + "/" + filename));
//      attachedFiles.add(new JangSoReviewAttachedFile(filename));
//    }
//    return attachedFiles;
//  }

  @GetMapping("recommendationList")
  public void recommendationList(Model model) throws Exception {
    model.addAttribute("recommendations", recommendationService.recommendationList());
  }

  @GetMapping("testrecom")
  public void test() {

  }

  @GetMapping("jangSoReviewList")
  public void jangSoReviewList(int recono, Model model) throws Exception {
    model.addAttribute("jangSoReviews", recommendationService.jangSoReviewList(recono));
    model.addAttribute("recommendation", recommendationService.getRecommendation(recono));
//    model.addAttribute("jangSos", jangSoReviewService.jangSo(recono));
  }


//  @GetMapping("detail")
//  public Map detail(int no) throws Exception {
//    Board board = boardService.get(no);
//    if (board == null) {
//      throw new Exception("해당 번호의 게시글이 없습니다!");
//    }
//
//    Map map = new HashMap();
//    map.put("board", board);
//    return map;
//  }
//
//  @PostMapping("update")
//  public String update(
//      Board board,
//      Part[] files,
//      HttpSession session)
//          throws Exception {
//
//    board.setAttachedFiles(saveAttachedFiles(files));
//
//    checkOwner(board.getNo(), session);
//
//    if (!boardService.update(board)) {
//      throw new Exception("게시글을 변경할 수 없습니다!");
//    }
//
//    return "redirect:list";
//  }
//
//  private void checkOwner(int boardNo, HttpSession session) throws Exception {
//    Member loginMember = (Member) session.getAttribute("loginMember");
//    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
//      throw new Exception("게시글 작성자가 아닙니다.");
//    }
//  }
//
//  @GetMapping("delete")
//  public String delete(
//      int no,
//      HttpSession session)
//          throws Exception {
//
//    checkOwner(no, session);
//    if (!boardService.delete(no)) {
//      throw new Exception("게시글을 삭제할 수 없습니다.");
//    }
//
//    return "redirect:list";
//  }
//
//  @GetMapping("fileDelete")
//  public String fileDelete(
//      int no,
//      HttpSession session)
//          throws Exception {
//
//    AttachedFile attachedFile = boardService.getAttachedFile(no);
//
//    Member loginMember = (Member) session.getAttribute("loginMember");
//    Board board = boardService.get(attachedFile.getBoardNo());
//
//    if (board.getWriter().getNo() != loginMember.getNo()) {
//      throw new Exception("게시글 작성자가 아닙니다.");
//    }
//
//    if (!boardService.deleteAttachedFile(no)) {
//      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
//    }
//
//    return "redirect:detail?no=" + board.getNo();
//  }
}






