package com.xqf.getInfo.utils;

import com.xqf.getInfo.model.*;
import org.hyperic.sigar.SigarException;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:根据获取的数据进行一下计算，然后组合成对应的数据库插入类
 *
 * @author xqf
 * @create 2018-04-17 16:39
 */
public class UtilCompute {

    /**
     * 所有记录的聚合
     *
     * @return
     */
    public static List<BeanBase> getAllRecordsInfo() throws SigarException {
        List<BeanBase> result = new ArrayList<BeanBase>();
        BeanInfo_Net beanInfo_net = UtilXqf.getNetInfo();
        String ip = beanInfo_net.getNet_Ip();

        BeanTable_AllServer beanTable_allServer = new BeanTable_AllServer();
        beanTable_allServer.setIp(ip);
        beanTable_allServer.setTime(UtilDate.getCurrentTime());

        List<BeanTable_Server1Cpu> cpuTableList = new ArrayList<BeanTable_Server1Cpu>();
        List<BeanTable_Server1Disc> discTableList = new ArrayList<BeanTable_Server1Disc>();
        BeanTable_Server1MemNet memNet = new BeanTable_Server1MemNet();
        memNet.setIp(beanTable_allServer.getIp());
        memNet.setTime(beanTable_allServer.getTime());


        List<BeanInfo_CPU> cpuList = UtilXqf.getCpuInfo();
        computeCpu(cpuList, beanTable_allServer, cpuTableList);

        List<BeanInfo_Disc> discList = UtilXqf.getDiscInfo();
        computeDisc(discList, beanTable_allServer, discTableList);

        computeNet(beanInfo_net, beanTable_allServer, memNet);

        BeanInfo_Mem beanInfo_mem = BeanInfo_Mem.factoryMem();
        computeMem(beanInfo_mem, beanTable_allServer, memNet);
        result.add(beanTable_allServer);
        result.addAll(cpuTableList);
        result.addAll(discTableList);
        result.add(memNet);
        return result;
    }


    /**
     * 计算一下有关CPU的合计
     *
     * @param list
     * @param beanTable_allServer
     */

    public static void computeCpu(List<BeanInfo_CPU> list, BeanTable_AllServer beanTable_allServer, List<BeanTable_Server1Cpu> cpus) {
        double cpu_used = 0;
        double cpu_free = 0;
        double cpu_utilization = 0;

        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            BeanInfo_CPU beanInfo_cpu = list.get(i);
            sum += beanInfo_cpu.getCPU_AllUsedRate();

            BeanTable_Server1Cpu cpu = new BeanTable_Server1Cpu();
            cpu.setIp(beanTable_allServer.getIp());
            cpu.setTime(beanTable_allServer.getTime());

            cpu.setCpu_allusedrate(beanInfo_cpu.getCPU_AllUsedRate());
            cpu.setCpu_cache(beanInfo_cpu.getCPU_Cache());
            cpu.setCpu_classfication(beanInfo_cpu.getCPU_classification());
            cpu.setCpu_clock(beanInfo_cpu.getCPU_Clock());
            cpu.setCpu_currenterrorrate(beanInfo_cpu.getCPU_CurrentErrorRate());

            cpu.setCpu_currentwaitingrate(beanInfo_cpu.getCPU_CurrentWaitingRate());
            cpu.setCpu_number(beanInfo_cpu.getCPU_numer());
            cpu.setCpu_producer(beanInfo_cpu.getCPU_Producer());
            cpu.setCpu_sysusedrate(beanInfo_cpu.getCPU_SysUsedRate());
            cpu.setCpu_userusedrate(beanInfo_cpu.getCPU_UserUsedRate());
            cpu.setCpu_currentfreerate(beanInfo_cpu.getCPU_CurrentFreeRate());
            cpus.add(cpu);
        }
        cpu_utilization = sum / 4;
        cpu_used = cpu_utilization;
        cpu_free = 1 - cpu_utilization;
        beanTable_allServer.setCpu_used(cpu_used);
        beanTable_allServer.setCpu_free(cpu_free);
        beanTable_allServer.setCpu_utilization(cpu_utilization);
    }

    /**
     * 计算一下有关disc合计
     *
     * @param list                disc集合
     * @param beanTable_allServer
     */
    public static void computeDisc(List<BeanInfo_Disc> list, BeanTable_AllServer beanTable_allServer, List<BeanTable_Server1Disc> discs) {
        double disc_used = 0;
        double disc_free = 0;
        double disc_utilization = 0;

        double sumAllSize = 0;
        for (int i = 0; i < list.size(); i++) {


            BeanTable_Server1Disc disc = new BeanTable_Server1Disc();

            BeanInfo_Disc beanInfo_disc = list.get(i);
            disc_used += beanInfo_disc.getDISC_Used();
            disc_free += beanInfo_disc.getDISC_Free();
            sumAllSize += beanInfo_disc.getDISC_AllSize();

            disc.setIp(beanTable_allServer.getIp());
            disc.setTime(beanTable_allServer.getTime());
            disc.setDisc_name(beanInfo_disc.getDISC_name());
            disc.setDisc_free(beanInfo_disc.getDISC_Free());
            disc.setDisc_used(beanInfo_disc.getDISC_Used());
            disc.setDisc_utilization(beanInfo_disc.getDISC_Utilization() / 100);
            disc.setDisc_allsize(beanInfo_disc.getDISC_AllSize());
            disc.setDisc_letterclassfication(beanInfo_disc.getDISC_LetterClassification());
            disc.setDisc_letterclassficationname(beanInfo_disc.getDISC_LetterClassificationName());
            disc.setDisc_letterfilesysficationname(beanInfo_disc.getDISC_LetterFileSysClassificationName());
            disc.setDisc_lettername(beanInfo_disc.getDISC_LetterName());
            disc.setDisc_letterpath(beanInfo_disc.getDISC_LetterPath());
            disc.setDisc_lettersymbol(beanInfo_disc.getDISC_LetterSymbol());
            discs.add(disc);
        }
        disc_utilization = disc_used / sumAllSize;
        beanTable_allServer.setDisc_used(disc_used);
        beanTable_allServer.setDisc_free(disc_free);
        beanTable_allServer.setDisc_utilization(disc_utilization);
    }

    /**
     * 计算一下网络相关合计
     *
     * @param beanInfo_net
     * @param beanTable_allServer
     */
    private static void computeNet(BeanInfo_Net beanInfo_net, BeanTable_AllServer beanTable_allServer, BeanTable_Server1MemNet memNet) {
        double download = beanInfo_net.getNet_RecBytes();
        double upload = beanInfo_net.getNet_SentBytes();
        double utilization = upload / download;
        beanTable_allServer.setNet_upload(upload);
        beanTable_allServer.setNet_download(download);
        beanTable_allServer.setNet_utilization(utilization);


        memNet.setNet_devname(beanInfo_net.getNet_DevName());
        memNet.setNet_ip(beanTable_allServer.getIp());
        memNet.setNet_netmask(beanInfo_net.getNet_Netmask());
        memNet.setNet_recabandonedpackages(beanInfo_net.getNet_RecAbandonedPackages());
        memNet.setNet_recbytes(beanInfo_net.getNet_RecBytes());
        memNet.setNet_recerrorpackages(beanInfo_net.getNet_RecErrorPackages());
        memNet.setNet_sentabandonedpackages(beanInfo_net.getNet_SentAbandonedPackages());
        memNet.setNet_sentpackages(beanInfo_net.getNet_SentPackages());
        memNet.setNet_sentbytes(beanInfo_net.getNet_SentBytes());
        memNet.setNet_recpackages(beanInfo_net.getNet_RecPackages());
        memNet.setNet_senterrorpackages(beanInfo_net.getNet_SentErrorPackages());

    }


    /**
     * 计算一下内存合计
     *
     * @param beanInfo_mem
     * @param beanTable_allServer
     */
    private static void computeMem(BeanInfo_Mem beanInfo_mem, BeanTable_AllServer beanTable_allServer, BeanTable_Server1MemNet memNet) {
        beanTable_allServer.setMem_used(beanInfo_mem.getMeM_CurrentUsed());
        beanTable_allServer.setMem_free(beanInfo_mem.getMeM_AllSize() - beanInfo_mem.getMeM_CurrentUsed());
        beanTable_allServer.setMem_utilization(beanInfo_mem.getMeM_UsedPercent() / 100);

        memNet.setMem_allsize(beanInfo_mem.getMeM_AllSize());
        memNet.setMem_currentrested(beanInfo_mem.getMeM_CurrentRested());
        memNet.setMem_currentused(beanInfo_mem.getMeM_CurrentUsed());
        memNet.setMem_swapall(beanInfo_mem.getMeM_SwapAll());
        memNet.setMem_swapcurrentrested(beanInfo_mem.getMeM_SwapCurrentRested());
        memNet.setMem_swapcurrentused(beanInfo_mem.getMeM_SwapCurrentUsed());
        memNet.setMem_usedpercent(beanInfo_mem.getMeM_UsedPercent());
    }


    public static void main(String[] args) throws SigarException {
        getAllRecordsInfo();
    }


}