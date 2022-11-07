package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.ExhibitionReview;

import java.util.List;


public interface ExhibitionReviewService {

  List<ExhibitionReview> exhibitionReviewList(int exno) throws Exception;

void exhibitionReviewInsert(ExhibitionReview exhibitionReview) throws Exception;
  boolean exhibitionReviewDelete(int rvno) throws Exception;

boolean exhibitionReviewUpdate(ExhibitionReview exhibitionReview) throws Exception;

}
