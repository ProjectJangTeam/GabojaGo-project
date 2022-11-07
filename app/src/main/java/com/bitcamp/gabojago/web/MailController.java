package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.MailService;
import com.bitcamp.gabojago.service.MemberService;
import com.bitcamp.gabojago.vo.MailDto;
import com.bitcamp.gabojago.vo.Member;
import java.util.Random;
import javax.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MailController {

  @Autowired
  MemberService memberService;
  private final MailService mailService;

  public MailController(MailService mailService) {
    this.mailService = mailService;
  }

//  @GetMapping("/templateMail")
//  public String templateMailSend() {
//    return "templateMail";
//  }

  @ResponseBody
  @PostMapping("/mail/emailCode")
  public String sendTemplateMail(MailDto mailDto, Model model, String address) throws Exception {
    Member result = memberService.emailCheck(address);
    if (result == null) {
    int certificateNum = new Random().nextInt(888888) + 111111;

    mailDto.setTitle("가보자GO 이메일 인증 번호");
    mailDto.setAddress(address);
    mailDto.setCheckNum(certificateNum);
    mailService.sendTemplateMessage(mailDto);
    return Integer.toString(certificateNum);
    } else {
      return "false";
    }
  }

//  @ResponseBody
//  @PostMapping("/mail/codeConfirm")
//  public String codeConfirm(String answer) throws Exception {
//    if ()
//
//    return "";
//  }

}