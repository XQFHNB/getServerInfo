package com.xqf.getInfo.model;

public class BeanInfo_CPU {
    //    CPU编号
    private int CPU_number;
    //CPU的总量MHz
    private int CPU_Clock;
    //CPU生产商
    private String CPU_Producer;
    //    CPU类别:
    private String CPU_classification;
    //    CPU缓存数量:
    private long CPU_Cache;

    public int getCPU_numer() {
        return CPU_number;
    }

    public void setCPU_numer(int CPU_number) {
        this.CPU_number = CPU_number;
    }

    public int getCPU_Clock() {
        return CPU_Clock;
    }

    public void setCPU_Clock(int CPU_Clock) {
        this.CPU_Clock = CPU_Clock;
    }

    public String getCPU_Producer() {
        return CPU_Producer;
    }

    public void setCPU_Producer(String CPU_Producer) {
        this.CPU_Producer = CPU_Producer;
    }

    public String getCPU_classification() {
        return CPU_classification;
    }

    public void setCPU_classification(String CPU_classification) {
        this.CPU_classification = CPU_classification;
    }

    public long getCPU_Cache() {
        return CPU_Cache;
    }

    public void setCPU_Cache(long CPU_Cache) {
        this.CPU_Cache = CPU_Cache;
    }

    public double getCPU_UserUsedRate() {
        return CPU_UserUsedRate;
    }

    public void setCPU_UserUsedRate(double CPU_UserUsedRate) {
        this.CPU_UserUsedRate = CPU_UserUsedRate;
    }

    public double getCPU_SysUsedRate() {
        return CPU_SysUsedRate;
    }

    public void setCPU_SysUsedRate(double CPU_SysUsedRate) {
        this.CPU_SysUsedRate = CPU_SysUsedRate;
    }

    public double getCPU_CurrentWaitingRate() {
        return CPU_CurrentWaitingRate;
    }

    public void setCPU_CurrentWaitingRate(double CPU_CurrentWaitingRate) {
        this.CPU_CurrentWaitingRate = CPU_CurrentWaitingRate;
    }



    public double getCPU_CurrentErrorRate() {
        return CPU_CurrentErrorRate;
    }

    public void setCPU_CurrentErrorRate(double CPU_CurrentErrorRate) {
        this.CPU_CurrentErrorRate = CPU_CurrentErrorRate;
    }

    public double getCPU_CurrentFreeRate() {
        return CPU_CurrentFreeRate;
    }

    public void setCPU_CurrentFreeRate(double CPU_CurrentFreeRate) {
        this.CPU_CurrentFreeRate = CPU_CurrentFreeRate;
    }

    public double getCPU_AllUsedRate() {
        return CPU_AllUsedRate;
    }

    public void setCPU_AllUsedRate(double CPU_AllUsedRate) {
        this.CPU_AllUsedRate = CPU_AllUsedRate;
    }

    //    CPU用户使用率:
    private double CPU_UserUsedRate;
    //    CPU系统使用率:
    private double CPU_SysUsedRate;
    //    CPU当前等待率:    0.0%
    private double CPU_CurrentWaitingRate;
    //    CPU当前错误率:    0.0%
    private double CPU_CurrentErrorRate;
    //    CPU当前空闲率:    25.0%
    private double CPU_CurrentFreeRate;
    //    CPU总的使用率:    75.0%
    private double CPU_AllUsedRate;


    @Override
    public String toString() {
        String space = " ";
        StringBuffer sb = new StringBuffer();
        sb.append(this.CPU_number).append(space)
                .append(this.CPU_Clock).append(space)
                .append(this.CPU_Producer).append(space)
                .append(this.CPU_classification).append(space)
                .append(this.CPU_Cache).append(space)
                .append(this.CPU_UserUsedRate).append(space)
                .append(this.CPU_SysUsedRate).append(space)
                .append(this.CPU_CurrentWaitingRate).append(space)
                .append(this.CPU_CurrentErrorRate).append(space)
                .append(this.CPU_CurrentFreeRate).append(space)
                .append(this.CPU_AllUsedRate).append(space);
        return sb.toString();
    }
}
