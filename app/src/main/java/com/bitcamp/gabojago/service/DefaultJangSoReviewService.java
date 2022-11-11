
package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.JangSoReviewDao;
import com.bitcamp.gabojago.vo.JangSo;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultJangSoReviewService implements JangSoReviewService  {

  @Autowired
  JangSoReviewDao jangSoReviewDao;

  @Override
  public int jangSoReviewAdd(JangSoReview jangSoReview) throws Exception {
    return jangSoReviewDao.jangSoReviewAdd(jangSoReview);
  }

  @Override
  public List<JangSoReview> jangSoReviewList(int recono) throws Exception {
    return jangSoReviewDao.jangSoReviewList(recono);
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
}
