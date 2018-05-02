package com.xqf.getInfo.model;

/**
 * 描述:
 *
 * @author xqf
 * @create 2018-04-17 12:00
 */
public class BeanTable_Server1Disc implements BeanBase {
    private String type = "disc";
    private String time;
    private String ip;
    private String disc_name;
    private String disc_lettername;
    private String disc_letterpath;
    private long disc_lettersymbol;
    private String disc_letterclassfication;
    private String disc_letterclassficationname;
    private long disc_letterfilesysficationname;
    private Long disc_allsize;
    private Long disc_free;
    private Long disc_used;
    private Double disc_utilization;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDisc_name() {
        return disc_name;
    }

    public void setDisc_name(String disc_name) {
        this.disc_name = disc_name;
    }

    public String getDisc_lettername() {
        return disc_lettername;
    }

    public void setDisc_lettername(String disc_lettername) {
        this.disc_lettername = disc_lettername;
    }

    public String getDisc_letterpath() {
        return disc_letterpath;
    }

    public void setDisc_letterpath(String disc_letterpath) {
        this.disc_letterpath = disc_letterpath;
    }

    public long getDisc_lettersymbol() {
        return disc_lettersymbol;
    }

    public void setDisc_lettersymbol(long disc_lettersymbol) {
        this.disc_lettersymbol = disc_lettersymbol;
    }

    public String getDisc_letterclassfication() {
        return disc_letterclassfication;
    }

    public void setDisc_letterclassfication(String disc_letterclassfication) {
        this.disc_letterclassfication = disc_letterclassfication;
    }

    public String getDisc_letterclassficationname() {
        return disc_letterclassficationname;
    }

    public void setDisc_letterclassficationname(String disc_letterclassficationname) {
        this.disc_letterclassficationname = disc_letterclassficationname;
    }

    public long getDisc_letterfilesysficationname() {
        return disc_letterfilesysficationname;
    }

    public void setDisc_letterfilesysficationname(long disc_letterfilesysficationname) {
        this.disc_letterfilesysficationname = disc_letterfilesysficationname;
    }

    public Long getDisc_allsize() {
        return disc_allsize;
    }

    public void setDisc_allsize(Long disc_allsize) {
        this.disc_allsize = disc_allsize;
    }

    public Long getDisc_free() {
        return disc_free;
    }

    public void setDisc_free(Long disc_free) {
        this.disc_free = disc_free;
    }

    public Long getDisc_used() {
        return disc_used;
    }

    public void setDisc_used(Long disc_used) {
        this.disc_used = disc_used;
    }

    public Double getDisc_utilization() {
        return disc_utilization;
    }

    public void setDisc_utilization(Double disc_utilization) {
        this.disc_utilization = disc_utilization;
    }
}