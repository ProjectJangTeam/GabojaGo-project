package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.Member;


public interface MemberService {

  Member get(String id, String password) throws Exception;
}
