package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.Recommendation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendationDao {
  List<Recommendation> recommendationList(); // 나중에 날짜 받기

  Recommendation recommendationSelect(int recono);

  int recommendationAdd(Recommendation recommendation);

  Recommendation getRecommendation(int recono);

//  int delete(int recono);

//  int update(Recommendation recommendation);

}
