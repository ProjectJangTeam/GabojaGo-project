package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.EventService;
import com.bitcamp.gabojago.vo.event.Event;
import com.bitcamp.gabojago.vo.event.EventItem;
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

    @GetMapping("delete")
    public String delete(int no) throws Exception {
        eventService.delete(no);
        return "redirect:list";
    }

    @GetMapping("editForm")
    public void editForm(int no, Model model) throws Exception {
        model.addAttribute("event", eventService.get(no));
    }

    @PostMapping("update")
    public String update(
            Event event,
            HttpSession session) throws Exception {
        System.out.println("EventControllerUpdate :" + event.toString());
        eventService.update(event);
        return "redirect:list";
    }

    @GetMapping("item/addForm")
    public void itemAddForm(int no, Model model) throws Exception {
        model.addAttribute("eventNo", no);
    }

    @PostMapping("item/itemadd")
    public String itemAdd(
            EventItem eventItem,
            HttpSession session) throws Exception {
        System.out.println("eventCotrollerAdd_item:" + eventItem.toString());
        eventService.itemAdd(eventItem);
        return "redirect:../detail?no=" + eventItem.getEventNo();
    }
}
