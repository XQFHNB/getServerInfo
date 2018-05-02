package com.xqf.getInfo.model;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.List;

public class BeanInfo_Disc {
//    分区的盘符名称0,盘符名称相当于是序号
//    盘符名称:    C:\
//    盘符路径:    C:\
//    盘符标志:    0
//    盘符类型:    NTFS
//    盘符类型名:    local

    public String getDISC_name() {
        return DISC_name;
    }

    public void setDISC_name(String DISC_name) {
        this.DISC_name = DISC_name;
    }

    public String getDISC_LetterName() {
        return DISC_LetterName;
    }

    public void setDISC_LetterName(String DISC_LetterName) {
        this.DISC_LetterName = DISC_LetterName;
    }

    public String getDISC_LetterPath() {
        return DISC_LetterPath;
    }

    public void setDISC_LetterPath(String DISC_LetterPath) {
        this.DISC_LetterPath = DISC_LetterPath;
    }

    public long getDISC_LetterSymbol() {
        return DISC_LetterSymbol;
    }

    public void setDISC_LetterSymbol(long DISC_LetterSymbol) {
        this.DISC_LetterSymbol = DISC_LetterSymbol;
    }

    public String getDISC_LetterClassification() {
        return DISC_LetterClassification;
    }

    public void setDISC_LetterClassification(String DISC_LetterClassification) {
        this.DISC_LetterClassification = DISC_LetterClassification;
    }

    public String getDISC_LetterClassificationName() {
        return DISC_LetterClassificationName;
    }

    public void setDISC_LetterClassificationName(String DISC_LetterClassificationName) {
        this.DISC_LetterClassificationName = DISC_LetterClassificationName;
    }

    public int getDISC_LetterFileSysClassificationName() {
        return DISC_LetterFileSysClassificationName;
    }

    public void setDISC_LetterFileSysClassificationName(int DISC_LetterFileSysClassificationName) {
        this.DISC_LetterFileSysClassificationName = DISC_LetterFileSysClassificationName;
    }

    public long getDISC_AllSize() {
        return DISC_AllSize;
    }

    public void setDISC_AllSize(long DISC_AllSize) {
        this.DISC_AllSize = DISC_AllSize;
    }

    public long getDISC_Free() {
        return DISC_Free;
    }

    public void setDISC_Free(long DISC_Free) {
        this.DISC_Free = DISC_Free;
    }

    public long getDISC_Used() {
        return DISC_Used;
    }

    public void setDISC_Used(long DISC_Used) {
        this.DISC_Used = DISC_Used;
    }

    public double getDISC_Utilization() {
        return DISC_Utilization;
    }

    public void setDISC_Utilization(double DISC_Utilization) {
        this.DISC_Utilization = DISC_Utilization;
    }

//    盘符文件系统类型:    2
//    C:\总大小:    62413268KB
//    C:\剩余大小:    28715476KB
//    C:\可用大小:    28715476KB
//    C:\已经使用量:    33697792KB
//    C:\资源的利用率:    54.0%
//    C:\读出：    2715644
//    C:\写入：    4906363


    private String DISC_name;
    private String DISC_LetterName;
    private String DISC_LetterPath;
    private long DISC_LetterSymbol;
    private String DISC_LetterClassification;
    private String DISC_LetterClassificationName;
    private int DISC_LetterFileSysClassificationName;
    private long DISC_AllSize;
    private long DISC_Free;
    private long DISC_Used;
    private double DISC_Utilization;


    @Override
    public String toString() {
        String space = " ";
        StringBuffer sb = new StringBuffer();

        sb.append(this.DISC_name).append(space)
                .append(this.DISC_LetterName).append(space)
                .append(this.DISC_LetterPath).append(space)
                .append(this.DISC_LetterSymbol).append(space)
                .append(this.DISC_LetterClassification).append(space)
                .append(this.DISC_LetterClassificationName).append(space)
                .append(this.DISC_LetterFileSysClassificationName).append(space)
                .append(this.DISC_AllSize).append(space)
                .append(this.DISC_Free).append(space)
                .append(this.DISC_Used).append(space)
                .append(this.DISC_Utilization).append(space);
        return sb.toString();
    }


    /**
     * 单位是mb
     * @param i
     * @param fs
     * @return
     * @throws SigarException
     */
    public static BeanInfo_Disc factoryDisc(int i,FileSystem fs) throws SigarException {
        long den = 1024;
        BeanInfo_Disc bean=null;
        Sigar sigar = new Sigar();
        FileSystemUsage usage = null;
        if (fs.getType() == 2) {
            bean= new BeanInfo_Disc();
            bean.setDISC_name(i+"");
            bean.setDISC_LetterName(fs.getDevName());
            bean.setDISC_LetterPath(fs.getDirName());
            bean.setDISC_LetterSymbol(fs.getFlags());
            bean.setDISC_LetterClassification(fs.getSysTypeName());
            bean.setDISC_LetterClassificationName(fs.getTypeName());
            bean.setDISC_LetterFileSysClassificationName(fs.getType());
            usage = sigar.getFileSystemUsage(fs.getDirName());
            //单位是kb
            bean.setDISC_AllSize(usage.getTotal() / den);
            bean.setDISC_Free(usage.getFree() / den);
            bean.setDISC_Used(usage.getUsed() / den);
            bean.setDISC_Utilization(usage.getUsePercent() * 100);

        }
        return bean;
    }
}
