package com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewsParamDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;

    private String title;

    private String type;

    private Integer state;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

