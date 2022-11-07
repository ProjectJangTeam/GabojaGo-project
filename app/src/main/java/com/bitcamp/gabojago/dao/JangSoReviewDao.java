package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.JangSo;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.Recommendation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JangSoReviewDao {
//  JangSo jangSo(int recono);

  List<JangSoReview> jangSoReviewList(int recono);

  int jangSoReviewAdd(JangSoReview jangSoReview);

  //Recommendation recommendationSelect(int recono);

  //int exhibitionInsert(Recommendation recommendation);

  //int delete(int recono);

  //int update(Recommendation recommendation);

}
