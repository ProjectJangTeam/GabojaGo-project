package com.bitcamp.gabojago.vo.event;

import java.sql.Date;

public class Event {

    private Integer no;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private Boolean disclosure;
    private String eventCode;
    private Integer capacity;

    @Override
    public String toString() {
        return "EventBoard{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", disclosure=" + disclosure +
                ", eventCode='" + eventCode + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getDisclosure() {
        return disclosure;
    }

    public void setDisclosure(Boolean disclosure) {
        this.disclosure = disclosure;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
