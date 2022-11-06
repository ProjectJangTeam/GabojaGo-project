package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.qna.QnaBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaDao {
    int insert(QnaBoard qnaBoard);

    List<QnaBoard> findAll();

    QnaBoard findByNo(int no);

}
