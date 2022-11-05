package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.Member;


public interface MemberService {

  Member idCheck(String id) throws Exception;

  Member nickNameCheck(String nickName) throws Exception;



  Member get(String id, String password) throws Exception;

  boolean join(String email, String phoneNo, Member member) throws Exception;

  Member phoneNoCheck(String phoneNo) throws Exception;

  Member emailCheck(String email) throws Exception;
}
