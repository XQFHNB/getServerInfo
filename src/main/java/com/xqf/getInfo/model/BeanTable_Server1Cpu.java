package com.xqf.getInfo.model;

/**
 * 描述:
 *
 * @author xqf
 * @create 2018-04-17 11:59
 */
public class BeanTable_Server1Cpu  implements BeanBase{
    private String type="cpu";
    private String time;
    private String ip;
    private long cpu_number;
    private long cpu_clock;
    private String cpu_producer;
    private String cpu_classfication;
    private long cpu_cache;
    private Double cpu_userusedrate;
    private Double cpu_sysusedrate;
    private Double cpu_currentwaitingrate;
    private Double cpu_currenterrorrate;
    private Double cpu_currentfreerate;
    private Double cpu_allusedrate;

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

    public long getCpu_number() {
        return cpu_number;
    }

    public void setCpu_number(long cpu_number) {
        this.cpu_number = cpu_number;
    }

    public long getCpu_clock() {
        return cpu_clock;
    }

    public void setCpu_clock(long cpu_clock) {
        this.cpu_clock = cpu_clock;
    }

    public String getCpu_producer() {
        return cpu_producer;
    }

    public void setCpu_producer(String cpu_producer) {
        this.cpu_producer = cpu_producer;
    }

    public String getCpu_classfication() {
        return cpu_classfication;
    }

    public void setCpu_classfication(String cpu_classfication) {
        this.cpu_classfication = cpu_classfication;
    }

    public long getCpu_cache() {
        return cpu_cache;
    }

    public void setCpu_cache(long cpu_cache) {
        this.cpu_cache = cpu_cache;
    }

    public Double getCpu_userusedrate() {
        return cpu_userusedrate;
    }

    public void setCpu_userusedrate(Double cpu_userusedrate) {
        this.cpu_userusedrate = cpu_userusedrate;
    }

    public Double getCpu_sysusedrate() {
        return cpu_sysusedrate;
    }

    public void setCpu_sysusedrate(Double cpu_sysusedrate) {
        this.cpu_sysusedrate = cpu_sysusedrate;
    }

    public Double getCpu_currentwaitingrate() {
        return cpu_currentwaitingrate;
    }

    public void setCpu_currentwaitingrate(Double cpu_currentwaitingrate) {
        this.cpu_currentwaitingrate = cpu_currentwaitingrate;
    }

    public Double getCpu_currenterrorrate() {
        return cpu_currenterrorrate;
    }

    public void setCpu_currenterrorrate(Double cpu_currenterrorrate) {
        this.cpu_currenterrorrate = cpu_currenterrorrate;
    }

    public Double getCpu_currentfreerate() {
        return cpu_currentfreerate;
    }

    public void setCpu_currentfreerate(Double cpu_currentfreerate) {
        this.cpu_currentfreerate = cpu_currentfreerate;
    }

    public Double getCpu_allusedrate() {
        return cpu_allusedrate;
    }

    public void setCpu_allusedrate(Double cpu_allusedrate) {
        this.cpu_allusedrate = cpu_allusedrate;
    }
}