package com.bitcamp.gabojago.vo;

import java.util.List;

public class JangSoReview {

  private int prvno; // 장소후기번호
  private String cont; // 내용
  private int recono; // 코스추천글번호
  private int plno; // 장소번호

  private String plname; // 장소이름

  //private JangSo jangSo; // 장소 목록들


  // 첨부파일 정보를 저장할 필드
  private List<JangSoReviewAttachedFile> attachedFiles;

  public int getPrvno() {
    return prvno;
  }

  public void setPrvno(int prvno) {
    this.prvno = prvno;
  }

  public String getCont() {
    return cont;
  }

  public void setCont(String cont) {
    this.cont = cont;
  }

  public int getRecono() {
    return recono;
  }

  public void setRecono(int recono) {
    this.recono = recono;
  }

  public int getPlno() {
    return plno;
  }

  public void setPlno(int plno) {
    this.plno = plno;
  }

  public String getPlname() {
    return plname;
  }

  public void setPlname(String plname) {
    this.plname = plname;
  }

  public List<JangSoReviewAttachedFile> getAttachedFiles() {
    return attachedFiles;
  }

  public void setAttachedFiles(List<JangSoReviewAttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }

  @Override
  public String toString() {
    return "JangSoReview{" +
            "prvno=" + prvno +
            ", cont='" + cont + '\'' +
            ", recono=" + recono +
            ", plno=" + plno +
            ", plname='" + plname + '\'' +
            ", attachedFiles=" + attachedFiles +
            '}';
  }
}
