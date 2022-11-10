package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.EventService;
import com.bitcamp.gabojago.vo.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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

    @GetMapping("addForm")
    public void addForm() throws Exception {

    }

    @PostMapping("add")
    public String add(
            Event event,
            HttpSession session) throws Exception {
        System.out.println("eventController : " + event.toString());
        eventService.add(event);
        return "redirect:list";
    }

    @GetMapping("detail")
    public void detail(int no, Model model) throws Exception {
        model.addAttribute("event", eventService.get(no));
    }



}
