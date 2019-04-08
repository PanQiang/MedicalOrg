package com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DownloadDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;

    private String fileName;

    private Integer type;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

