package com.bitcamp.gabojago.vo;

import java.sql.Date;
import java.util.List;

public class Recommendation {

  private int recono; // 코스추천글번호
  //private String id; // 아이디
  private String title; // 코스추천글제목
  private Date wdate; // 코스추천글 등록일
  private int cnt; // 조회수
  private boolean act; // 활성여부
  private boolean pet; // 반려동물동반가능여부
  private boolean frd; // 친구동행추천
  private boolean cple; // 연인동행추천
  private boolean fmly; // 가족동행추천
  private boolean solo; // 혼자여행추천
  private int tpno; // 이동수단번호

  private Member writer; // 글쓴 회원정보
  //private List<JangSoReview> jangSoReviews;
  private JangSoReview jangSoReview;

  public int getRecono() {
    return recono;
  }

  public void setRecono(int recono) {
    this.recono = recono;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getWdate() {
    return wdate;
  }

  public void setWdate(Date wdate) {
    this.wdate = wdate;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public boolean isAct() {
    return act;
  }

  public void setAct(boolean act) {
    this.act = act;
  }

  public boolean isPet() {
    return pet;
  }

  public void setPet(boolean pet) {
    this.pet = pet;
  }

  public boolean isFrd() {
    return frd;
  }

  public void setFrd(boolean frd) {
    this.frd = frd;
  }

  public boolean isCple() {
    return cple;
  }

  public void setCple(boolean cple) {
    this.cple = cple;
  }

  public boolean isFmly() {
    return fmly;
  }

  public void setFmly(boolean fmly) {
    this.fmly = fmly;
  }

  public boolean isSolo() {
    return solo;
  }

  public void setSolo(boolean solo) {
    this.solo = solo;
  }

  public int getTpno() {
    return tpno;
  }

  public void setTpno(int tpno) {
    this.tpno = tpno;
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public JangSoReview getJangSoReview() {
    return jangSoReview;
  }

  public void setJangSoReview(JangSoReview jangSoReview) {
    this.jangSoReview = jangSoReview;
  }

  @Override
  public String toString() {
    return "Recommendation{" +
            "recono=" + recono +
            ", title='" + title + '\'' +
            ", wdate=" + wdate +
            ", cnt=" + cnt +
            ", act=" + act +
            ", pet=" + pet +
            ", frd=" + frd +
            ", cple=" + cple +
            ", fmly=" + fmly +
            ", solo=" + solo +
            ", tpno=" + tpno +
            ", writer=" + writer +
            ", jangSoReview=" + jangSoReview +
            '}';
  }
}
