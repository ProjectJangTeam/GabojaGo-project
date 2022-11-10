package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.EventDao;
import com.bitcamp.gabojago.vo.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDao eventDao;

    @Transactional
    @Override
    public List<Event> list() throws Exception {
        return eventDao.findAll();
    }

    @Override
    public void add(Event event) throws Exception {
        System.out.println("EventServiceImple : " + event.toString());

        if (eventDao.insert(event) == 0) {
            throw new Exception("게시글 등록 실패!!");
        }
    }

    @Override
    public Event get(int no) throws Exception {
        return eventDao.findByNo(no);
    }

    @Override
    public Boolean delete(int no) throws Exception {
        return eventDao.deleteByNo(no) > 0;
    }

}
