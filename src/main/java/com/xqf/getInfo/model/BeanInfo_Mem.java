package com.xqf.getInfo.model;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class BeanInfo_Mem {
//
//    内存总量:    8290196K av
//    当前内存使用量:    7632504K used
//    当前内存剩余量:    657692K free


    //内存使用率
    private double MeM_UsedPercent;

    public double getMeM_UsedPercent() {
        return MeM_UsedPercent;
    }

    public void setMeM_UsedPercent(double meM_UsedPercent) {
        MeM_UsedPercent = meM_UsedPercent;
    }

    public double getMeM_AllSize() {
        return MeM_AllSize;
    }

    public void setMeM_AllSize(double meM_AllSize) {
        MeM_AllSize = meM_AllSize;
    }

    public double getMeM_CurrentUsed() {
        return MeM_CurrentUsed;
    }

    public void setMeM_CurrentUsed(double meM_CurrentUsed) {
        MeM_CurrentUsed = meM_CurrentUsed;
    }

    public double getMeM_CurrentRested() {
        return MeM_CurrentRested;
    }

    public void setMeM_CurrentRested(double meM_CurrentRested) {
        MeM_CurrentRested = meM_CurrentRested;
    }

    public double getMeM_SwapAll() {
        return MeM_SwapAll;
    }

    public void setMeM_SwapAll(double meM_SwapAll) {
        MeM_SwapAll = meM_SwapAll;
    }

    public double getMeM_SwapCurrentUsed() {
        return MeM_SwapCurrentUsed;
    }

    public void setMeM_SwapCurrentUsed(double meM_SwapCurrentUsed) {
        MeM_SwapCurrentUsed = meM_SwapCurrentUsed;
    }

    public double getMeM_SwapCurrentRested() {
        return MeM_SwapCurrentRested;
    }

    public void setMeM_SwapCurrentRested(double meM_SwapCurrentRested) {
        MeM_SwapCurrentRested = meM_SwapCurrentRested;
    }

//    交换区总量:    20415920K av
//    当前交换区使用量:    17410116K used
//    当前交换区剩余量:    3005804K free

    //    内存总量:    8290196K av
    private double MeM_AllSize;
    //    当前内存使用量:    7632504K used
    private double MeM_CurrentUsed;
    //    当前内存剩余量:    657692K free
    private double MeM_CurrentRested;
    //    交换区总量:    20415920K av
    private double MeM_SwapAll;
    //    当前交换区使用量:    17410116K used
    private double MeM_SwapCurrentUsed;
    //    当前交换区剩余量:    3005804K free
    private double MeM_SwapCurrentRested;

    @Override
    public String toString() {
        String space=" ";
        StringBuffer sb=new StringBuffer();
        sb.append(this.MeM_AllSize).append(space)
                .append(this.MeM_CurrentUsed).append(space)
                .append(this.MeM_CurrentRested).append(space)
                .append(this.MeM_UsedPercent).append(space)
                .append(this.MeM_SwapAll).append(space)
                .append(this.MeM_SwapCurrentUsed).append(space)
                .append(this.MeM_SwapCurrentRested).append(space);

        return sb.toString();
    }


    /**
     * 组装内存信息，单位是b
     * @return
     * @throws SigarException
     */
    public static BeanInfo_Mem factoryMem() throws SigarException {
        double den=1024*1024;
        Sigar sigar = new Sigar();

        BeanInfo_Mem bean=new BeanInfo_Mem();
        Mem mem = sigar.getMem();

        bean.setMeM_AllSize(mem.getTotal()/den);
        bean.setMeM_CurrentUsed(mem.getUsed()/den);
        bean.setMeM_CurrentRested(mem.getFree()/den);
        bean.setMeM_UsedPercent(mem.getUsedPercent());

        Swap swap = sigar.getSwap();
        bean.setMeM_SwapAll(swap.getTotal()/den);
        bean.setMeM_SwapCurrentUsed(swap.getUsed()/den);
        bean.setMeM_SwapCurrentRested(swap.getFree()/den);

//
//        // 内存总量
//        System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
//        // 当前内存使用量
//        System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
//        // 当前内存剩余量
//        System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
//        // 交换区总量
//        System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
//        // 当前交换区使用量
//        System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
//        // 当前交换区剩余量
//        System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
        return bean;

    }
}
