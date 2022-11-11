package com.bitcamp.gabojago.dao;


import com.bitcamp.gabojago.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ModifyMyPageDao {

    int profileUpdate(Member member);

    int myAccountUpdate(Member member);

    Member findById(String id);

}
