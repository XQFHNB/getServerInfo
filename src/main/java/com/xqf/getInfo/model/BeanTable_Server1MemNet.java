package com.xqf.getInfo.model;

/**
 * 描述:
 *
 * @author xqf
 * @create 2018-04-17 11:58
 */
public class BeanTable_Server1MemNet implements BeanBase {
    private String type="memnet";
    private String time;
    private String ip;
    private Double mem_usedpercent;
    private Double mem_allsize;
    private Double mem_currentused;
    private Double mem_currentrested;
    private Double mem_swapall;
    private Double mem_swapcurrentused;
    private Double mem_swapcurrentrested;
    private String net_devname;
    private String net_ip;
    private String net_netmask;
    private Long net_recpackages;

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

    public Double getMem_usedpercent() {
        return mem_usedpercent;
    }

    public void setMem_usedpercent(Double mem_usedpercent) {
        this.mem_usedpercent = mem_usedpercent;
    }

    public Double getMem_allsize() {
        return mem_allsize;
    }

    public void setMem_allsize(Double mem_allsize) {
        this.mem_allsize = mem_allsize;
    }

    public Double getMem_currentused() {
        return mem_currentused;
    }

    public void setMem_currentused(Double mem_currentused) {
        this.mem_currentused = mem_currentused;
    }

    public Double getMem_currentrested() {
        return mem_currentrested;
    }

    public void setMem_currentrested(Double mem_currentrested) {
        this.mem_currentrested = mem_currentrested;
    }

    public Double getMem_swapall() {
        return mem_swapall;
    }

    public void setMem_swapall(Double mem_swapall) {
        this.mem_swapall = mem_swapall;
    }

    public Double getMem_swapcurrentused() {
        return mem_swapcurrentused;
    }

    public void setMem_swapcurrentused(Double mem_swapcurrentused) {
        this.mem_swapcurrentused = mem_swapcurrentused;
    }

    public Double getMem_swapcurrentrested() {
        return mem_swapcurrentrested;
    }

    public void setMem_swapcurrentrested(Double mem_swapcurrentrested) {
        this.mem_swapcurrentrested = mem_swapcurrentrested;
    }

    public String getNet_devname() {
        return net_devname;
    }

    public void setNet_devname(String net_devname) {
        this.net_devname = net_devname;
    }

    public String getNet_ip() {
        return net_ip;
    }

    public void setNet_ip(String net_ip) {
        this.net_ip = net_ip;
    }

    public String getNet_netmask() {
        return net_netmask;
    }

    public void setNet_netmask(String net_netmask) {
        this.net_netmask = net_netmask;
    }

    public Long getNet_recpackages() {
        return net_recpackages;
    }

    public void setNet_recpackages(Long net_recpackages) {
        this.net_recpackages = net_recpackages;
    }

    public Long getNet_sentpackages() {
        return net_sentpackages;
    }

    public void setNet_sentpackages(Long net_sentpackages) {
        this.net_sentpackages = net_sentpackages;
    }

    public Long getNet_recbytes() {
        return net_recbytes;
    }

    public void setNet_recbytes(Long net_recbytes) {
        this.net_recbytes = net_recbytes;
    }

    public Long getNet_sentbytes() {
        return net_sentbytes;
    }

    public void setNet_sentbytes(Long net_sentbytes) {
        this.net_sentbytes = net_sentbytes;
    }

    public Long getNet_recerrorpackages() {
        return net_recerrorpackages;
    }

    public void setNet_recerrorpackages(Long net_recerrorpackages) {
        this.net_recerrorpackages = net_recerrorpackages;
    }

    public Long getNet_senterrorpackages() {
        return net_senterrorpackages;
    }

    public void setNet_senterrorpackages(Long net_senterrorpackages) {
        this.net_senterrorpackages = net_senterrorpackages;
    }

    public Long getNet_recabandonedpackages() {
        return net_recabandonedpackages;
    }

    public void setNet_recabandonedpackages(Long net_recabandonedpackages) {
        this.net_recabandonedpackages = net_recabandonedpackages;
    }

    public Long getNet_sentabandonedpackages() {
        return net_sentabandonedpackages;
    }

    public void setNet_sentabandonedpackages(Long net_sentabandonedpackages) {
        this.net_sentabandonedpackages = net_sentabandonedpackages;
    }

    private Long net_sentpackages;
    private Long net_recbytes;
    private Long net_sentbytes;
    private Long net_recerrorpackages;
    private Long net_senterrorpackages;
    private Long net_recabandonedpackages;
    private Long net_sentabandonedpackages;
}