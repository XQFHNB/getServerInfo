package com.xqf.getInfo.model;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanInfo_Net {

//    网络设备名:    eth0
//    IP地址:    0.0.0.0

    public String getNet_DevName() {
        return Net_DevName;
    }

    public void setNet_DevName(String net_DevName) {
        Net_DevName = net_DevName;
    }

    public String getNet_Ip() {
        return Net_Ip;
    }

    public void setNet_Ip(String net_Ip) {
        Net_Ip = net_Ip;
    }

    public String getNet_Netmask() {
        return Net_Netmask;
    }

    public void setNet_Netmask(String net_Netmask) {
        Net_Netmask = net_Netmask;
    }

    public long getNet_RecPackages() {
        return Net_RecPackages;
    }

    public void setNet_RecPackages(long net_RecPackages) {
        Net_RecPackages = net_RecPackages;
    }

    public long getNet_SentPackages() {
        return Net_SentPackages;
    }

    public void setNet_SentPackages(long net_SentPackages) {
        Net_SentPackages = net_SentPackages;
    }

    public long getNet_RecBytes() {
        return Net_RecBytes;
    }

    public void setNet_RecBytes(long net_RecBytes) {
        Net_RecBytes = net_RecBytes;
    }

    public long getNet_SentBytes() {
        return Net_SentBytes;
    }

    public void setNet_SentBytes(long net_SentBytes) {
        Net_SentBytes = net_SentBytes;
    }

    public long getNet_RecErrorPackages() {
        return Net_RecErrorPackages;
    }

    public void setNet_RecErrorPackages(long net_RecErrorPackages) {
        Net_RecErrorPackages = net_RecErrorPackages;
    }

    public long getNet_SentErrorPackages() {
        return Net_SentErrorPackages;
    }

    public void setNet_SentErrorPackages(long net_SentErrorPackages) {
        Net_SentErrorPackages = net_SentErrorPackages;
    }

    public long getNet_RecAbandonedPackages() {
        return Net_RecAbandonedPackages;
    }

    public void setNet_RecAbandonedPackages(long net_RecAbandonedPackages) {
        Net_RecAbandonedPackages = net_RecAbandonedPackages;
    }

    public long getNet_SentAbandonedPackages() {
        return Net_SentAbandonedPackages;
    }

    public void setNet_SentAbandonedPackages(long net_SentAbandonedPackages) {
        Net_SentAbandonedPackages = net_SentAbandonedPackages;
    }

//    子网掩码:    0.0.0.0
//    eth0接收的总包裹数:73281
//    eth0发送的总包裹数:92134
//    eth0接收到的总字节数:9982880
//    eth0发送的总字节数:12599494
//    eth0接收到的错误包数:0
//    eth0发送数据包时的错误数:0
//    eth0接收时丢弃的包数:0
//    eth0发送时丢弃的包数:0


    private String Net_DevName;
    private String Net_Ip;
    private String Net_Netmask;
    private long Net_RecPackages;
    private long Net_SentPackages;
    private long Net_RecBytes;
    private long Net_SentBytes;
    private long Net_RecErrorPackages;
    private long Net_SentErrorPackages;
    private long Net_RecAbandonedPackages;
    private long Net_SentAbandonedPackages;

    @Override
    public String toString() {
        String space = " ";
        StringBuffer sb = new StringBuffer();
        sb.append(this.Net_DevName).append(space)
                .append(this.Net_Ip).append(space)
                .append(this.Net_Netmask).append(space)
                .append(this.Net_RecPackages).append(space)
                .append(this.Net_SentPackages).append(space)
                .append(this.Net_RecBytes).append(space)
                .append(this.Net_SentBytes).append(space)
                .append(this.Net_RecErrorPackages).append(space)
                .append(this.Net_SentErrorPackages).append(space)
                .append(this.Net_RecAbandonedPackages).append(space)
                .append(this.Net_SentAbandonedPackages).append(space);
        return sb.toString();
    }


    /**
     * 一系列的组装
     *
     * @return 返回一个netbeaninfo
     * @throws SigarException
     */

    public static BeanInfo_Net factoryNet() throws SigarException {
        Sigar sigar = new Sigar();
        String ifNames[] = sigar.getNetInterfaceList();

        for (int i = 0; i < ifNames.length; i++) {
            String name = ifNames[i];
            BeanInfo_Net bean = new BeanInfo_Net();
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);

            bean.setNet_DevName(name);
            String ip = ifconfig.getAddress();
            if (!isboolIp(ip)) {
                continue;
            }
            bean.setNet_Ip(ifconfig.getAddress());
            bean.setNet_Netmask(ifconfig.getNetmask());
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
            bean.setNet_RecPackages(ifstat.getRxPackets());
            bean.setNet_SentPackages(ifstat.getTxPackets());
            bean.setNet_RecBytes(ifstat.getRxBytes());
            bean.setNet_SentBytes(ifstat.getTxBytes());
            bean.setNet_RecErrorPackages(ifstat.getRxErrors());
            bean.setNet_SentErrorPackages(ifstat.getTxErrors());
            bean.setNet_RecAbandonedPackages(ifstat.getRxDropped());
            bean.setNet_SentAbandonedPackages(ifstat.getTxDropped());
            return bean;
        }

        return null;
    }

    /**
     * 判断IP格式和范围
     */
    public static boolean isboolIp(String ipAddress) {
        if (ipAddress.length() < 7 || ipAddress.length() > 15) {
            return false;
        }
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(ipAddress);
        boolean flag = mat.find();
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isboolIp("192.168.56.1"));
    }

}
