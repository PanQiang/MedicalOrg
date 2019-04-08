package com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchResult {

    private String keyword;

    private Long Id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String createTime;

    private String title;

    private String summary;

    private Integer type;

    private Integer medicalCount;
    private Integer policyCount;
    private Integer downloadCount;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getMedicalCount() {
        return medicalCount;
    }

    public void setMedicalCount(Integer medicalCount) {
        this.medicalCount = medicalCount;
    }

    public Integer getPolicyCount() {
        return policyCount;
    }

    public void setPolicyCount(Integer policyCount) {
        this.policyCount = policyCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}

