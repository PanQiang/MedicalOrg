package com.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "MANAGE_USER")
public class WechatUser {
    @Id
    @Column(name = "ID")
    private Long id;

    public  static final String Table="MANAGE_USER";
    

    @Column(name = "USERNAME")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}