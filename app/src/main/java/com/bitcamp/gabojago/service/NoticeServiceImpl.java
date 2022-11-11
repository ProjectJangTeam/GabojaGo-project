package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.NoticeDao;
import com.bitcamp.gabojago.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Override
    public void noticeAdd(Notice notice) throws Exception {
        if (noticeDao.insert(notice) == 0) {
            throw new Exception("게시글 등록 실패!");
        }
    }

    @Override
    public Notice get(int no) throws Exception {
        return noticeDao.findByNo(no);
    }

    @Override
    public List<Notice> noticeList() throws Exception {
        return noticeDao.findAll();
    }
}
