package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.EventDao;
import com.bitcamp.gabojago.dao.EventItemDao;
import com.bitcamp.gabojago.vo.event.Event;
import com.bitcamp.gabojago.vo.event.EventItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao eventDao;
    @Autowired
    EventItemDao eventItemDao;

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
    public boolean delete(int no) throws Exception {
        return eventDao.deleteByNo(no) > 0;
    }

    @Override
    public boolean update(Event event) throws Exception {
        System.out.println("EventServiceImplUpdate : " + event.toString());
        if (eventDao.update(event) == 0) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public void itemAdd(EventItem eventItem) throws Exception {
        System.out.println("EventServiceImpl_item :" +eventItem.toString());

        // 파라미터에는 이벤트 번호가 들어가야함
        int itemsCount = eventItemDao.getItemsCountByEventNo(eventItem.getEventNo());
        // 신규 이벤트 아이템 지급 순위 로직
        int ranking = itemsCount + 1;
        // 신규 이벤트 아이템 지급 순위 세팅
        eventItem.setRanking(ranking);
        System.out.println("EventServiceImpl_item after :" +eventItem.toString());

        if (eventItemDao.insert(eventItem) == 0) {
            throw new Exception("게시글 등록 실패!!");
        }
    }
}
