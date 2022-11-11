package com.bitcamp.gabojago.vo;

import java.sql.Date;

public class JangComment {

  private int cmno; //댓글번호
  private String cont; // 리뷰 내용
  private Date wdate; // 작성일
  private String id; // 아이디
  private int recono; // 전시회 번호

  public int getCmno() {
    return cmno;
  }

  public void setCmno(int cmno) {
    this.cmno = cmno;
  }

  public String getCont() {
    return cont;
  }

  public void setCont(String cont) {
    this.cont = cont;
  }

  public Date getWdate() {
    return wdate;
  }

  public void setWdate(Date wdate) {
    this.wdate = wdate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getRecono() {
    return recono;
  }

  public void setRecono(int recono) {
    this.recono = recono;
  }

  @Override
  public String toString() {
    return "JangComment{" +
            "cmno=" + cmno +
            ", cont='" + cont + '\'' +
            ", wdate=" + wdate +
            ", id='" + id + '\'' +
            ", recono=" + recono +
            '}';
  }
}
