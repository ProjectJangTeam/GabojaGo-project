package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberDao {

   Member findById(String id);

   Member findByNickName(String nickName);

   Member findByIdPassword(
          @Param("id") String id,
          @Param("password") String password);

  Member findByEmail(String email);

  Member findByPhoneNo(String phoneNo);

  int join(Member member);

  /* 밑으로 꼉이 수정중*/
  int delete(String id);

  List<Member> findAll();

  Member findByIdAll(String id);

  int update(Member member);
}
