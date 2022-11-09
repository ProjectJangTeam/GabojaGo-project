package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.event.Event;

import java.util.List;

public interface EventService {

    List<Event> list() throws Exception;

    void add(Event event) throws Exception;

}
