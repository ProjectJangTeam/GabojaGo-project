package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Recommendation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendationDao {

  // recommendationAdd - 1
  int recommendationAdd(Recommendation recommendation);

  // recommendationAdd - 2
  int jangSoReviewAdd(JangSoReview jangSoReview);

  // recommendationAdd - 3
  int jangSoReviewAttachedFileAdd(JangSoReviewAttachedFile jangSoReviewAttachedFile);

  // recommendationList
  List<Recommendation> recommendationList(); // 나중에 날짜 받기

  // recommendationDetail - 1
  Recommendation getRecommendation(int recono);

  // recommendationDisable
  int disableRecommend(int recono);

  int setCntRecommendation(int recono);

}
