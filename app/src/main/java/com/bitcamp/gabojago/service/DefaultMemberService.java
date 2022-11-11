package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.ExhibitionReviewDao;
import com.bitcamp.gabojago.dao.MemberDao;
import com.bitcamp.gabojago.vo.ExhibitionReview;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultMemberService implements MemberService {
  @Autowired
  MemberDao memberDao;

  @Autowired
  ExhibitionReviewDao exhibitionReviewDao;

  @Override
  public Member idCheck(String id) throws Exception {
    return memberDao.findById(id);
  }

  @Override
  public Member nickNameCheck(String nickName) throws Exception {
    return memberDao.findByNickName(nickName);
  }

  @Override
  public Member get(String id, String password) throws Exception {
    return memberDao.findByIdPassword(id, password);
  }

  @Override
  public boolean join(String email, String phoneNo, Member member) throws Exception {
    if(memberDao.findByEmail(email) != null || memberDao.findByPhoneNo(phoneNo) != null) {
      return false;
    } else {
      memberDao.join(member);
      return true;
    }
  }

  @Override
  public Member phoneNoCheck(String phoneNo) throws Exception {
    return memberDao.findByPhoneNo(phoneNo);
  }

  @Override
  public Member emailCheck(String email) throws Exception {
    return memberDao.findByEmail(email);
  }



  /* 밑으로 꼉이 수정중*/
  @Transactional
  @Override
  public boolean delete(String id) throws Exception {
    /*boardDao.deleteFilesByMemberBoards(no); // 회원이 작성한 게시글의 모든 첨부파일 삭제
    boardDao.deleteByMember(no); // 회원이 작성한 게시글 삭제*/
/*
    exhibitionReviewDao.deleteByMember(Integer.parseInt(id)); // 전시회 리뷰 삭제
*/
    return memberDao.delete(id) > 0; // 회원 삭제
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  @Override
  public Member get(String id)throws Exception {
    return memberDao.findByIdAll(id);
  }

  public boolean update(Member member) throws Exception {
    return memberDao.update(member) > 0;
  }


}
