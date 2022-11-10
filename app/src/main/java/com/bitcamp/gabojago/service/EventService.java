package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.event.Event;
import com.bitcamp.gabojago.vo.event.EventItem;

import java.util.List;

public interface EventService {

    List<Event> list() throws Exception;

    void add(Event event) throws Exception;

    Event get(int no) throws Exception;

    boolean delete(int no) throws Exception;

    boolean update(Event event) throws Exception;

    void itemAdd(EventItem eventItem) throws Exception;

}
