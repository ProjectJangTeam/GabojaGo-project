package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.qna.QnaBoard;

import java.util.List;

public interface QnaService {

    void add(QnaBoard qnaBoard) throws Exception;

    List<QnaBoard> list() throws Exception;

    QnaBoard get(int no) throws Exception;



}
