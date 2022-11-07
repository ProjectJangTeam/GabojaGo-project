package com.bitcamp.gabojago.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDto {
  private String from;
  private String address;
  private String title;
  private String content;
  private String template;
  private int checkNum;
}