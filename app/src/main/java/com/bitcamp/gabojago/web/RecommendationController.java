package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.JangCommentService;
import com.bitcamp.gabojago.vo.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;

import com.bitcamp.gabojago.service.RecommendationService;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/recommendation/")
public class RecommendationController {
  @Autowired
  ServletContext sc;
  @Autowired
  RecommendationService recommendationService;

  @Autowired
  JangCommentService jangCommentService;

  public RecommendationController() {
    System.out.println("RecommendationController() 호출됨!");
  }

  @GetMapping("recommendationForm")
  public void form() throws Exception {
  }

  // Add method 시작
  @Transactional
  @PostMapping("recommendationAdd")
  public String recommendationAdd(
      String place1, MultipartFile[] files1, String cont1,
      String place2, MultipartFile[] files2, String cont2,
      String place3, MultipartFile[] files3, String cont3,
      String place4, MultipartFile[] files4, String cont4,
      String place5, MultipartFile[] files5, String cont5,
      String pet, String frd, String cple, String fmly, String solo, String tpname,
      HttpSession session, Recommendation recommendation) throws Exception {

    // 작성자정보 set하기
    recommendation.setWriter((Member) session.getAttribute("loginMember"));

    // 변수분류 저장
    MultipartFile[][] files = {files1, files2, files3, files4, files5};
    String[] cont = {cont1, cont2, cont3, cont4, cont5};
    String[] place = {place1, place2, place3, place4, place5};

    // recommendation에 JangSoReview List를 set하기
    recommendation.setJangSoReviews(saveJangSoReviews(files, cont, place));

    // recommendation에 meta 데이터 set하기
    recommendation.setTpname(tpname);
    if (pet != null) {recommendation.setPet(true);} else {recommendation.setPet(false);}
    if (frd != null) {recommendation.setFrd(true);} else {recommendation.setFrd(false);}
    if (cple != null) {recommendation.setCple(true);} else {recommendation.setCple(false);}
    if (fmly != null) {recommendation.setFmly(true);} else {recommendation.setFmly(false);}
    if (solo != null) {recommendation.setSolo(true);} else {recommendation.setSolo(false);}

    // recommendation add하기
    recommendationService.recommendationAdd(recommendation);

    return "redirect:recommendationList";
  }

  private List<JangSoReview> saveJangSoReviews(
      MultipartFile[][] files, String[] cont, String[] place) throws Exception {

    // JangSoReview List 생성
    List<JangSoReview> jangSoReviews = new ArrayList<>();

    // 각각의 JangSoReview 저장
    for (int i = 0; i < cont.length; i++) {
      // 내용이 없거나 장소정보가 없다면 저장하지 않는다. (=첨부파일 유무와 관계없다)
      if (cont[i].length() == 0 || place[i].length() == 0) {
        continue;
      }

      // 장소정보 parsing

      // JangSoReview 객체 생성
      JangSoReview jangSoReview = new JangSoReview();
      // 해당 리뷰글 set
      jangSoReview.setCont(cont[i]);
      // 장소명 parsing 및 set
      jangSoReview.setPlname(place[i].split(", ")[0]);
      // 장소주소 parsing 및 set
      jangSoReview.setAdrs(place[i].split(", ")[1]);
      // 첨부파일 저장 및 set
      jangSoReview.setAttachedFiles(saveJangSoReviewAttachedFiles(files[i]));
      // JangSoReview List에 처리가 끝난 JangSoReview add
      jangSoReviews.add(jangSoReview);
    }

    return jangSoReviews;
  }

  private List<JangSoReviewAttachedFile> saveJangSoReviewAttachedFiles(
      MultipartFile[] files)
      throws Exception {

  List<JangSoReviewAttachedFile> jangSoReviewAttachedFiles = new ArrayList<>();
  String dirPath = sc.getRealPath("/board/files");

    for (MultipartFile file : files) {
    if (file.isEmpty()) {
      continue;
    }

    String filepath = UUID.randomUUID().toString();
    String filename = file.getOriginalFilename();
    file.transferTo(new File(dirPath + "/" + filepath));
      jangSoReviewAttachedFiles.add(new JangSoReviewAttachedFile(filepath, filename));
  }
    return jangSoReviewAttachedFiles;
  }
  // Add method 끝

  @GetMapping("recommendationList")
  public void recommendationList(Model model) throws Exception {
    model.addAttribute("recommendations", recommendationService.recommendationList());
  }

  @GetMapping("recommendationDetail")
  public void jangSoReviewList(int recono, Model model) throws Exception {
    recommendationService.setCntRecommendation(recono);
    model.addAttribute("recommendation", recommendationService.getRecommendation(recono));
    model.addAttribute("jangSoReviews", recommendationService.getJangSoReviewList(recono));
    model.addAttribute("jangComments", jangCommentService.jangCommentList(recono));
  }

  @GetMapping("disableRecommend")
  public String disableRecommend(int recono) throws Exception {
    if (!recommendationService.disableRecommend(recono)) {
      throw new Exception("코스추천글 삭제 실패");
    }

    return "redirect:recommendationList";
  }

  //------------------------JangComment----------------------------
//  @Autowired
//  JangCommentService jangCommentService;

  @ResponseBody  //데이터 전달 빠르게 확인 가능
  @RequestMapping("comment-select-list/{recono}")
  public List<JangComment> jangCommentList(@PathVariable("recono") int recono) throws Exception{
    return jangCommentService.jangCommentList(recono);
  }

  @PostMapping("jangCommentAdd")
  public String jangCommentInsert(JangComment jangComment,
                                  HttpSession session) throws Exception {
    jangCommentService.jangCommentInsert(jangComment);
    return "redirect:../recommendation/recommendationDetail?recono="+jangComment.getRecono();
  }

  @GetMapping("jangCommentDelete")
  public String jangCommentDelete(int cmno, HttpSession session, JangComment jangComment) throws Exception {
    //  checkOwner(no, session);
    int recono = jangComment.getRecono();
    if(!jangCommentService.jangCommentDelete(cmno)) {
      throw new Exception("댓글을 삭제 할 수 없습니다.");
    }

    return "redirect:../recommendation/recommendationDetail?recono="+recono;
  }

  @PostMapping("update")
  public String update(JangComment jangComment, HttpSession session) throws Exception{

//  checkOwner(board.getNo(), session);

    if(!jangCommentService.jangCommentUpdate(jangComment)){
      throw new Exception("댓글을 변경 할 수 없습니다!");
    }
    return "redirect:../recommendation/recommendationList";
  }


}






