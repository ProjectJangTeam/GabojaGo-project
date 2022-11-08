package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support/event/")
public class EventController {
    @Autowired
    EventService eventService;

    public EventController(EventService eventService) {
        System.out.println("EventController() 호출됨>-<");
        this.eventService = eventService;
    }

    @GetMapping("list")
    public void list(Model model) throws Exception {
        model.addAttribute("events", eventService.list());
    }
}
