package com.bitcamp.gabojago.service;


import com.bitcamp.gabojago.vo.Notice;

import java.util.List;

public interface NoticeService {
    void noticeAdd(Notice notice) throws Exception;

    boolean noticeEditUpdate(Notice notice) throws Exception;

    boolean noticeDelete(int no) throws Exception;

    Notice get(int no) throws Exception;

    Notice getEdit(int no) throws Exception;

    List<Notice> noticeList() throws Exception;
}
