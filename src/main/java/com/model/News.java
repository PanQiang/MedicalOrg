package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * NEWS表存放医保热点和政务公开的数据,通过place区分是医保热点还是政务公开,type是外键 NEWS_TYPE的ID
 */
@Table(name = "NEWS")
@Data
public class News {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="id",sequenceName="SEQ_NEWS")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PLACE")
    private Integer place;//1医保热点   2政务公开

    @Column(name = "STATE")
    private Integer state;

    @Column(name = "CONTENT")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @Column(name = "READ_COUNT")
    private Integer readCount;

    @Column(name = "LIKE_COUNT")
    private Integer likeCount;

    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "IMG_URL")
    private String imgUrl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "UPDATE_TIME")
    private LocalDateTime updateTime;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "SEOTITLE")
    private String seoTitle;

    @Column(name = "SEOSUMMARY")
    private String seoSummary;

    @Column(name = "SEOKEYWORD")
    private String seoKeyword;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "SENDDATE")
    private LocalDateTime sendDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoSummary() {
        return seoSummary;
    }

    public void setSeoSummary(String seoSummary) {
        this.seoSummary = seoSummary;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }
}