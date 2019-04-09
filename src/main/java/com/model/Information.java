package com.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="INFORMATION")
public class Information {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="id",sequenceName="SEQ_INFORMATION")
    private Long id;

    @Column(name="SPONSER")
    private String sponser;

    @Column(name="IDENTIFICATION")
    private String identification;

    @Column(name="COPYRIGHT")
    private String copyright;

    @Column(name="ICPCODE")
    private String icpCode;

    @Column(name="TOPLOGO")
    private String topLogo;

    @Column(name="BOTTOMIMG1")
    private String bottomImg1;

    @Column(name="BOTTOMIMG2")
    private String bottomImg2;

    @Lob
    @Column(name="ABOUT_US")
    private String aboutUs;

    @Lob
    @Column(name="CALL_US")
    private String callUs;

    @Lob
    @Column(name="LEGAL_STATEMENT")
    private String legalStatement;

    @Column(name="LONGITUDE")
    private String longitude;//经度

    @Column(name="LATITUDE")//纬度
    private String latitude;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSponser() {
        return sponser;
    }

    public void setSponser(String sponser) {
        this.sponser = sponser;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getIcpCode() {
        return icpCode;
    }

    public void setIcpCode(String icpCode) {
        this.icpCode = icpCode;
    }

    public String getTopLogo() {
        return topLogo;
    }

    public void setTopLogo(String topLogo) {
        this.topLogo = topLogo;
    }

    public String getBottomImg1() {
        return bottomImg1;
    }

    public void setBottomImg1(String bottomImg1) {
        this.bottomImg1 = bottomImg1;
    }

    public String getBottomImg2() {
        return bottomImg2;
    }

    public void setBottomImg2(String bottomImg2) {
        this.bottomImg2 = bottomImg2;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getCallUs() {
        return callUs;
    }

    public void setCallUs(String callUs) {
        this.callUs = callUs;
    }

    public String getLegalStatement() {
        return legalStatement;
    }

    public void setLegalStatement(String legalStatement) {
        this.legalStatement = legalStatement;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
