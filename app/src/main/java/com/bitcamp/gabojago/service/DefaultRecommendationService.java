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

  @Transactional
  @Override
  public void recommendationAdd(Recommendation recommendation) throws Exception {
    // 1) 코스추천글 등록
    if (recommendationDao.recommendationAdd(recommendation) == 0) {
      throw new Exception("게시글 등록 실패!");
    }

    // 여기부터
    // 자동증가한 코스추천글 recono 받아오기
    int recono = recommendation.getRecono();

    // 자동증가한 장소리뷰 번호를 받을 변수 준비
    int prvno;

    for (int i = 0; i < recommendation.getJangSoReviews().size(); i++) {
      // 각각의 장소리뷰에 코스추천글 번호 set하기
      recommendation.getJangSoReviews().get(i).setRecono(recono);

      // 각각의 장소리뷰 insert하기
      recommendationDao.jangSoReviewAdd(recommendation.getJangSoReviews().get(i));

      // 각각의 장소리뷰를 insert하면서 자동증가한 prvno 받아오기
      prvno = recommendation.getJangSoReviews().get(i).getPrvno();

      for (int j = 0; j < recommendation.getJangSoReviews().get(i).getAttachedFiles().size(); j++) {
        // 장소리뷰를 insert하면서 자동증가한 prvno를 장소리뷰 첨부파일에 set하기
        recommendation.getJangSoReviews().get(i).getAttachedFiles().get(j).setPrvno(prvno);

        // 장소리뷰 첨부파일 insert하기
        recommendationDao.jangSoReviewAttachedFileAdd(
            recommendation.getJangSoReviews().get(i).getAttachedFiles().get(j)
        );
      }
    }
//    recommendationDao.jangSoReviewAdd(recommendation.getJangSoReviews().get(i));

//
//    // 2) 장소리뷰 등록
//    recommendationDao.jangSoReviewAdd(recommendation);
//
//    for (int i = 0; i < recommendation.getJangSoReviews().size(); i++) {
//      // 3) 첨부파일 등록
//      recommendationDao.jangSoReviewAttachedFileAdd(recommendation.getJangSoReviews().get(i));
//    }
  }

  @Override
  public boolean update(Recommendation recommendation) throws Exception {
    return false;
  }

  @Override
  public Recommendation getRecommendation(int recono) throws Exception {
    return recommendationDao.getRecommendation(recono);
  }

  @Override
  public List<Recommendation> recommendationList() throws Exception {
    return recommendationDao.recommendationList();
  }

  @Override
  public boolean disableRecommend(int recono) {
    return recommendationDao.disableRecommend(recono) > 0;
  }

  // ---------------------------------------------------------


  @Override
  public int jangSoReviewAdd(JangSoReview jangSoReview) throws Exception {
    return jangSoReviewDao.jangSoReviewAdd(jangSoReview);
  }

  @Override
  public List<JangSoReview> jangSoReviewList(int recono) throws Exception {
    return jangSoReviewDao.jangSoReviewList(recono);
  }

  @Override
  public List<JangSoReviewAttachedFile> attachedFileList(int recono) {
    return jangSoReviewDao.attachedFileList(recono);
  }

//  @Override
//  public JangSo jangSo(int recono) throws Exception {
//    return jangSoReviewDao.jangSo(recono);
//  }

  @Override
  public JangSoReviewAttachedFile getAttachedFile(int fileNo) throws Exception {
    return null;
  }

  @Override
  public boolean deleteAttachedFile(int fileNo) throws Exception {
    return false;
  }

//  @Override
//  public List<Exhibition> exhibitionList() throws Exception {
//    return exhibitionDao.exhibitionList();
//  }
//
//  public Exhibition exhibitionSelect(int exno) throws Exception{
//    return exhibitionDao.exhibitionSelect(exno);
//  }
//
//  @Transactional
//  @Override
//  public void insert(Exhibition exhibition) throws Exception {
//    // 1) 게시글 등록
//    if (exhibitionDao.exhibitionInsert(exhibition) == 0) {
//      throw new Exception("게시글 등록 실패!");
//    }
//
//    // 2) 첨부파일 등록 나중에 생성
//
//  }
//
//  @Transactional
//  @Override
//  public boolean delete(int exno) throws Exception {
//    // 1) 첨부파일 삭제
//    // 2) 리뷰 삭제
//
//    // 3) 게시글 삭제
//    return exhibitionDao.delete(exno) > 0;
//
//  }
//
//  @Transactional
//  @Override
//  public boolean update(Exhibition exhibition) throws Exception {
//    // 1) 게시글 변경
//    if(exhibitionDao.update(exhibition) == 0) {
//      return false;
//    }
//    //2) 첨부파일 등록
//
//
//    return true;
//  }
//
//  @Override
//  public Exhibition get(int exno) throws Exception {
//    return exhibitionDao.exhibitionSelect(exno);
//  }

}
