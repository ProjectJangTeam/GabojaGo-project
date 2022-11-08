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
  @GetMapping("jangSoReviewForm2")
  public void form() throws Exception {
  }

  @Transactional
  @PostMapping("recommendationAdd")
  public String recommendationAdd(
      MultipartFile[] files1, String cont1,
      MultipartFile[] files2, String cont2,
      MultipartFile[] files3, String cont3,
      MultipartFile[] files4, String cont4,
      MultipartFile[] files5, String cont5,
      HttpSession session, Recommendation recommendation) throws Exception {

    // 작성자정보 set하기
    recommendation.setWriter((Member) session.getAttribute("loginMember"));

    // 변수분류 저장
    MultipartFile[][] files = {files1, files2, files3, files4, files5};
    String[] cont = {cont1, cont2, cont3, cont4, cont5};

    // recommendation에 JangSoReview List를 set하기
    recommendation.setJangSoReviews(saveJangSoReviews(files, cont));

    // recommendation add하기
    recommendationService.recommendationAdd(recommendation);

    return "redirect:recommendationList";
  }

  private List<JangSoReview> saveJangSoReviews(MultipartFile[][] files, String[] cont)
      throws Exception {

    // JangSoReview List 생성
    List<JangSoReview> jangSoReviews = new ArrayList<>();

    // 각각의 JangSoReview 저장
    for (int i = 0; i < cont.length; i++) {
      // 내용이 없다면 저장하지 않는다. (=첨부파일 유무와 관계없다)
      if (cont[i] == null) {
        continue;
      }

      // JangSoReview 객체 생성
      JangSoReview jangSoReview = new JangSoReview();
      jangSoReview.setCont(cont[i]);
      jangSoReview.setAttachedFiles(saveJangSoReviewAttachedFiles(files[i]));
      jangSoReviews.add(jangSoReview);
    }

    return jangSoReviews;
  }

  // 민구작성메서드
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


  // 민구작성메서드
  @GetMapping("disableRecommend")
  public String disableRecommend(int recono) throws Exception {
    if (!recommendationService.disableRecommend(recono)) {
      throw new Exception("코스추천글 삭제 실패");
    }

    return "redirect:recommendationList";
  }

  @GetMapping("recommendationList")
  public void recommendationList(Model model) throws Exception {
    model.addAttribute("recommendations", recommendationService.recommendationList());
  }

  @GetMapping("testrecom")
  public void test() {

  }

  @GetMapping("jangSoReviewList")
  public void jangSoReviewList(int recono, Model model) throws Exception {
    model.addAttribute("recommendation", recommendationService.getRecommendation(recono));
    model.addAttribute("jangSoReviews", recommendationService.jangSoReviewList(recono));
    model.addAttribute("attachedFiles", recommendationService.attachedFileList(recono));
//    model.addAttribute("jangSos", jangSoReviewService.jangSo(recono));
  }

}






