package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.JangSo;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Recommendation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JangSoReviewDao {

  // recommendationDetail - 2
  List<JangSoReview> getJangSoReviewList(int recono);
}
