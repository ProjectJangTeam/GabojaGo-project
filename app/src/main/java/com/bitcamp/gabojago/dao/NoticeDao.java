package com.bitcamp.gabojago.dao;


import com.bitcamp.gabojago.vo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao {
    int insert(Notice notice);

    Notice findByNo(int no);

    List<Notice> findAll();
}
