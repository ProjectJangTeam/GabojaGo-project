package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Recommendation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendationDao {
  List<Recommendation> recommendationList(); // 나중에 날짜 받기

  Recommendation recommendationSelect(int recono);

  int recommendationAdd(Recommendation recommendation);

  int jangSoReviewAdd(JangSoReview jangSoReview);

  int jangSoReviewAttachedFileAdd(JangSoReviewAttachedFile jangSoReviewAttachedFile);

//  int jangSoReviewAdd(Recommendation recommendation);

//  int jangSoReviewAttachedFileAdd(JangSoReview jangSoReview);

  Recommendation getRecommendation(int recono);

  int disableRecommend(int recono);


//  int delete(int recono);

//  int update(Recommendation recommendation);

}