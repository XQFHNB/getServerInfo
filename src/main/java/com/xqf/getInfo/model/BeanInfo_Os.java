package com.xqf.getInfo.model;

public class BeanInfo_Os {

//    操作系统:    x64
//    操作系统CpuEndian():    little

    public String getOS_bits() {
        return OS_bits;
    }

    public void setOS_bits(String OS_bits) {
        this.OS_bits = OS_bits;
    }

    public String getOS_DataModel() {
        return OS_DataModel;
    }

    public void setOS_DataModel(String OS_DataModel) {
        this.OS_DataModel = OS_DataModel;
    }

    public String getOS_Saler() {
        return OS_Saler;
    }

    public void setOS_Saler(String OS_Saler) {
        this.OS_Saler = OS_Saler;
    }

    public String getOS_Edition() {
        return OS_Edition;
    }

    public void setOS_Edition(String OS_Edition) {
        this.OS_Edition = OS_Edition;
    }

//    操作系统DataModel():    64
//    操作系统的描述:    Microsoft
//    操作系统的卖主:    Microsoft
//    操作系统的卖主名:
//    操作系统名称:
//    操作系统卖主类型:    ¨0
//    操作系统的版本号:    10.0

//    操作系统:    x64
//    操作系统DataModel():    64
//    操作系统的卖主:    Microsoft
//   操作系统的版本号:    10.0


    private String OS_bits;
    private String OS_DataModel;
    private String OS_Saler;
    private String OS_Edition;


    @Override
    public String toString() {
        String space=" ";
        StringBuffer sb=new StringBuffer();

        sb.append(this.OS_bits).append(space)
                .append(this.OS_DataModel).append(space)
                .append(this.OS_Saler).append(space)
                .append(this.OS_Edition).append(space);
        return sb.toString();
    }
}
