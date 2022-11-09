package com.bitcamp.gabojago.dao;


import com.bitcamp.gabojago.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileDao {

    int update(Member member);

    Member findById(String id);

}
