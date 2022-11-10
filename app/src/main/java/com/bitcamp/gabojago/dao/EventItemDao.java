package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.event.Event;
import com.bitcamp.gabojago.vo.event.EventItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventItemDao {
//    List<EventItem> findAll();

    int insert(EventItem eventItem);

    int getItemsCountByEventNo(int no);

//
//    int deleteByNo(int no);
//
//    int update(EventItem eventItem);
}
