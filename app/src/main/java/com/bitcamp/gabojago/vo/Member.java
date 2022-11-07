package com.bitcamp.gabojago.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

  private String id;
  private String password;
  private String nickName;
  private Date createdDate;
  private String profileFig;
  private String name;
  private String email;
  private String phoneNo;
  private Date birthDay;
  private Character gender;
  private String snsAddress;
  private String mbti;
  private String status;

  @Override
  public String toString() {
    return "Member{" +
            "id='" + id + '\'' +
            ", password='" + password + '\'' +
            ", nickName='" + nickName + '\'' +
            ", createdDate=" + createdDate +
            ", profileFig='" + profileFig + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phoneNo='" + phoneNo + '\'' +
            ", birthDay=" + birthDay +
            ", gender=" + gender +
            ", snsAddress='" + snsAddress + '\'' +
            ", mbti='" + mbti + '\'' +
            ", status='" + status + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getProfileFig() {
    return profileFig;
  }

  public void setProfileFig(String profileFig) {
    this.profileFig = profileFig;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(Character gender) {
    this.gender = gender;
  }

  public String getSnsAddress() {
    return snsAddress;
  }

  public void setSnsAddress(String snsAddress) {
    this.snsAddress = snsAddress;
  }

  public String getMbti() {
    return mbti;
  }

  public void setMbti(String mbti) {
    this.mbti = mbti;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
