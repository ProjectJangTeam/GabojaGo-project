package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.MemberDao;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMemberService implements MemberService {
  @Autowired
  MemberDao memberDao;

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

}
