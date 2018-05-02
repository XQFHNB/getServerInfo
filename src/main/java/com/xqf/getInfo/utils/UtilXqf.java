package com.xqf.getInfo.utils;

import com.xqf.getInfo.model.*;
import org.hyperic.sigar.*;

import java.util.ArrayList;
import java.util.List;

public class UtilXqf {

    /**
     * 获取CPU的信息
     *
     * @return
     * @throws SigarException
     */
    public static List<BeanInfo_CPU> getCpuInfo() throws SigarException {
        Sigar sigar = new Sigar();
        List<BeanInfo_CPU> result = new ArrayList<BeanInfo_CPU>();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都有用
            BeanInfo_CPU cpu = new BeanInfo_CPU();
            CpuInfo info = infos[i];
            CpuPerc cpuInfo = cpuList[i];

            cpu.setCPU_numer(i + 1);
            cpu.setCPU_Clock(info.getMhz());
            cpu.setCPU_Producer(info.getVendor());
            cpu.setCPU_classification(info.getModel());
            cpu.setCPU_Cache(info.getCacheSize());

            cpu.setCPU_UserUsedRate(cpuInfo.getUser());
            cpu.setCPU_SysUsedRate(cpuInfo.getSys());
            cpu.setCPU_CurrentWaitingRate(cpuInfo.getWait());
            cpu.setCPU_CurrentErrorRate(cpuInfo.getNice());
            cpu.setCPU_CurrentFreeRate(cpuInfo.getIdle());
            cpu.setCPU_AllUsedRate(cpuInfo.getCombined());

            result.add(cpu);
        }
        return result;
    }

    /**
     * 获取内存信息
     *
     * @return
     * @throws SigarException
     */
    public static BeanInfo_Mem getMemInfo() throws SigarException {
        return BeanInfo_Mem.factoryMem();
    }


    /**
     * 获取网络信息（暂时假设只有一个网卡）
     *
     * @return
     * @throws SigarException
     */
    public static BeanInfo_Net getNetInfo() throws SigarException {
        return BeanInfo_Net.factoryNet();
    }


    /**
     * 获取磁盘信息，因为可能有多个，所以返回一个列表
     *
     * @return
     * @throws SigarException
     */
    public static List<BeanInfo_Disc> getDiscInfo() throws SigarException {
        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();
        List<BeanInfo_Disc> result = new ArrayList<BeanInfo_Disc>();
        for (int i = 0; i < fslist.length; i++) {
            BeanInfo_Disc beanInfo_disc = BeanInfo_Disc.factoryDisc(i + 1, fslist[i]);
            if (beanInfo_disc != null) {
                result.add(beanInfo_disc);
            }
        }
        return result;
    }


    public static void printInfo() throws SigarException {
        System.out.println("=======cpu");
        List<BeanInfo_CPU> cpus = UtilXqf.getCpuInfo();
        for (int i = 0; i < cpus.size(); i++) {
            System.out.println(cpus.get(i));
        }
        System.out.println("=======mem");

        BeanInfo_Mem beanInfo_mem = UtilXqf.getMemInfo();
        System.out.println(beanInfo_mem);
        System.out.println("=======net");

        BeanInfo_Net beanInfo_net = UtilXqf.getNetInfo();
        System.out.println(beanInfo_net);

        System.out.println("=======disc");

        List<BeanInfo_Disc> discs = UtilXqf.getDiscInfo();
        for (int i = 0; i < discs.size() - 1; i++) {
            System.out.println(discs.get(i));
        }
    }

    public static void main(String[] args) {
        try {
            printInfo();
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
}
