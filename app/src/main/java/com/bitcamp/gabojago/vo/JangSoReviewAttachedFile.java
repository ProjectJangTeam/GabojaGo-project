package com.bitcamp.gabojago.vo;

public class JangSoReviewAttachedFile {
  private int recofno; // 장소후기첨부파일번호
  private int prvno; // 장소후기번호
  private String filepath; // 파일경로
  private String fname; // 파일이름

  public JangSoReviewAttachedFile() {}

  public JangSoReviewAttachedFile(String filepath) {
    this.filepath = filepath;
  }

  public int getRecofno() {
    return recofno;
  }

  public void setRecofno(int recofno) {
    this.recofno = recofno;
  }

  public int getPrvno() {
    return prvno;
  }

  public void setPrvno(int prvno) {
    this.prvno = prvno;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  @Override
  public String toString() {
    return "AttachedFile{" +
            "recofno=" + recofno +
            ", prvno=" + prvno +
            ", filepath='" + filepath + '\'' +
            ", fname='" + fname + '\'' +
            '}';
  }
}
