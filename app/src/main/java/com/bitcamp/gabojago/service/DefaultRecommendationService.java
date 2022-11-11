package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.JangSoReviewDao;
import com.bitcamp.gabojago.dao.RecommendationDao;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultRecommendationService implements RecommendationService  {
  @Autowired
  RecommendationDao recommendationDao;

  @Autowired
  JangSoReviewDao jangSoReviewDao;

  // recommendationAdd
  @Transactional
  @Override
  public void recommendationAdd(Recommendation recommendation) throws Exception {
    // 1) 코스추천글 등록
    if (recommendationDao.recommendationAdd(recommendation) == 0) {
      throw new Exception("코스추천글 등록 실패!");
    }

    // 자동증가한 코스추천글 recono 받아오기
    int recono = recommendation.getRecono();

    // 자동증가한 장소리뷰 번호를 받을 변수 준비
    int prvno;

    for (int i = 0; i < recommendation.getJangSoReviews().size(); i++) {
      // 각각의 장소리뷰에 코스추천글 번호 set하기
      recommendation.getJangSoReviews().get(i).setRecono(recono);

      // 각각의 장소리뷰 insert하기
      if (recommendationDao.jangSoReviewAdd(recommendation.getJangSoReviews().get(i)) == 0) {
        throw new Exception("장소리뷰 등록 실패!");
      }

      // 각각의 장소리뷰를 insert하면서 자동증가한 prvno 받아오기
      prvno = recommendation.getJangSoReviews().get(i).getPrvno();

      for (int j = 0; j < recommendation.getJangSoReviews().get(i).getAttachedFiles().size(); j++) {
        // 장소리뷰를 insert하면서 자동증가한 prvno를 장소리뷰 첨부파일에 set하기
        recommendation.getJangSoReviews().get(i).getAttachedFiles().get(j).setPrvno(prvno);

        // 장소리뷰 첨부파일 insert하기
        if (recommendationDao.jangSoReviewAttachedFileAdd(
            recommendation.getJangSoReviews().get(i).getAttachedFiles().get(j)
        ) == 0) {
          throw new Exception("장소리뷰첨부파일 등록 실패!");
        }
      }
    }
  }

  // recommendationList
  @Override
  public List<Recommendation> recommendationList() throws Exception {
    return recommendationDao.recommendationList();
  }

  // recommendationDetail - 1
  @Override
  public Recommendation getRecommendation(int recono) throws Exception {
    return recommendationDao.getRecommendation(recono);
  }

  // recommendationDetail - 2
  @Override
  public List<JangSoReview> getJangSoReviewList(int recono) throws Exception {
    return jangSoReviewDao.getJangSoReviewList(recono);
  }

  public void setCntRecommendation(int recono) throws Exception {
    recommendationDao.setCntRecommendation(recono);
  }

  // recommendationDisable
  @Override
  public boolean disableRecommend(int recono) {
    return recommendationDao.disableRecommend(recono) > 0;
  }

}
