package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.JangSo;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;

import java.util.List;


public interface JangSoReviewService {

  int jangSoReviewAdd(JangSoReview jangSoReview) throws Exception;

  List<JangSoReview> jangSoReviewList(int recono) throws Exception;

  JangSoReviewAttachedFile getAttachedFile(int fileNo) throws Exception;

  boolean deleteAttachedFile(int fileNo) throws Exception;


}