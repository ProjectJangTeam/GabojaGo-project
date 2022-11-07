package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Recommendation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface RecommendationService {

  void recommendationAdd(Recommendation recommendation) throws Exception;

  boolean update(Recommendation recommendation) throws Exception;

  Recommendation getRecommendation(int recono) throws Exception;

  //boolean delete(int no) throws Exception;

  List<Recommendation> recommendationList() throws Exception;

  boolean disableRecommend(int recono);

  //AttachedFile getAttachedFile(int fileNo) throws Exception;

  //boolean deleteAttachedFile(int fileNo) throws Exception;


  int jangSoReviewAdd(JangSoReview jangSoReview) throws Exception;

  List<JangSoReview> jangSoReviewList(int recono) throws Exception;

  JangSoReviewAttachedFile getAttachedFile(int fileNo) throws Exception;

  boolean deleteAttachedFile(int fileNo) throws Exception;

}