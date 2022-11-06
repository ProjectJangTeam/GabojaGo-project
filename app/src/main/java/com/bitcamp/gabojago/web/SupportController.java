package com.bitcamp.gabojago.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/")
public class SupportController {

    @GetMapping("support")
    public void support() {

    }
}
