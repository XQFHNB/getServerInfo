package com.xqf.getInfo.db;

import com.xqf.getInfo.model.*;
import com.xqf.getInfo.utils.UtilCompute;
import com.xqf.getInfo.utils.UtilString;
import org.hyperic.sigar.SigarException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.xqf.getInfo.utils.UtilConstants.*;

public class DBHelper {


    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://master:3306/graduation_1";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "125880";

    static final String INSERT_INTO = "insert into ";
    static final String VALUES = "values ";
    static final String TRANSFER = "\"";


    // TODO: 2018/4/17 感觉这里的其他表名应该不能给出来一个定值，应该是按照某种原则进行随机的，从通用的原则上来说这里应该是需要建表语句的
    static final String SPACE = " ";
    static final String DOT = ",";
    static final String BRA_L = "(";
    static final String BRA_R = ")";

    /**
     * 获取connection
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (connection != null) {
                System.out.println("连接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 批處理添加
     *
     * @param table
     * @param sbKeys
     * @param sbValues
     * @param statement
     * @throws SQLException
     */
    public static void addSQLBatch(String table, StringBuffer sbKeys, StringBuffer sbValues, Statement statement) throws SQLException {
        StringBuffer result = new StringBuffer(INSERT_INTO);
        result.append(table).append(SPACE).append(BRA_L).append(sbKeys).append(BRA_R)
                .append(VALUES).append(BRA_L).append(sbValues).append(BRA_R);
        String sqlString = result.toString();
        statement.addBatch(sqlString);
    }


    /**
     * 工厂方法转发，执行所有的插入操作，每个插入不同表额操作主要是插入的表名和内容不一样
     */
    public static void insertAction() throws SigarException, SQLException {
        Connection connection = getConnection();

        Statement statement = connection.createStatement();
        List<BeanBase> list = UtilCompute.getAllRecordsInfo();
        for (int i = 0; i < list.size(); i++) {
            BeanBase beanBase = list.get(i);
            if (beanBase.getType() == BEAN_TYPE_ALL) {
                insertTableAllServer((BeanTable_AllServer) beanBase, statement);
            } else if (beanBase.getType() == BEAN_TYPE_CPU) {
                insertTableCPU((BeanTable_Server1Cpu) beanBase, statement);
            } else if (beanBase.getType() == BEAN_TYPE_DISC) {
                insertTableDisc((BeanTable_Server1Disc) beanBase, statement);
            } else {
                insertTableMemNet((BeanTable_Server1MemNet) beanBase, statement);
            }
        }
        statement.executeBatch();
        System.out.printf("全部插入");
    }

    /**
     * CREATE TABLE `server_gentically`(
     * `time` varchar(30)  PRIMARY KEY,
     * `ip` varchar(30),
     * `cpu_used`  double,
     * `cpu_free` double,
     * `cpu_utilization` double,
     * `mem_used` double,
     * `mem_free` double,
     * `mem_utilization` double,
     * `disc_used` double,
     * `disc_free` double,
     * `disc_utilization` double,
     * `net_upload` double,
     * `net_download` double,
     * `net_utilization` double,
     * 往综合表里插入数据
     * )
     */
    public static void insertTableAllServer(BeanTable_AllServer bean, Statement statement) throws SQLException {
        StringBuffer sbKeys = new StringBuffer();
        sbKeys.append(TABLE_S_FILEDS0).append(DOT)
                .append(TABLE_S_FILEDS1).append(DOT)
                .append(TABLE_S_FILEDS2).append(DOT)
                .append(TABLE_S_FILEDS3).append(DOT)
                .append(TABLE_S_FILEDS4).append(DOT)
                .append(TABLE_S_FILEDS5).append(DOT)
                .append(TABLE_S_FILEDS6).append(DOT)
                .append(TABLE_S_FILEDS7).append(DOT)
                .append(TABLE_S_FILEDS8).append(DOT)
                .append(TABLE_S_FILEDS9).append(DOT)
                .append(TABLE_S_FILEDS10).append(DOT)
                .append(TABLE_S_FILEDS11).append(DOT)
                .append(TABLE_S_FILEDS12).append(DOT)
                .append(TABLE_S_FILEDS13);
        StringBuffer sbValues = new StringBuffer();
        sbValues.append(TRANSFER).append(bean.getTime()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getIp()).append(TRANSFER).append(DOT)
                .append(bean.getCpu_used()).append(DOT)
                .append(bean.getCpu_free()).append(DOT)
                .append(bean.getCpu_utilization()).append(DOT)
                .append(bean.getMem_used()).append(DOT)
                .append(bean.getMem_free()).append(DOT)
                .append(bean.getMem_utilization()).append(DOT)
                .append(bean.getDisc_used()).append(DOT)
                .append(bean.getDisc_free()).append(DOT)
                .append(bean.getDisc_utilization()).append(DOT)
                .append(bean.getNet_upload()).append(DOT)
                .append(bean.getNet_download()).append(DOT)
                .append(bean.getNet_utilization());
        addSQLBatch(TABLE_ALLSERVER, sbKeys, sbValues, statement);
    }


    public static void insertTableCPU(BeanTable_Server1Cpu bean, Statement statement) throws SQLException {
        StringBuffer sbValues = new StringBuffer();
        StringBuffer sbKeys = new StringBuffer();
        sbKeys.append(TABLE_S1_CPU_FILEDS1).append(DOT)
                .append(TABLE_S1_CPU_FILEDS2).append(DOT)
                .append(TABLE_S1_CPU_FILEDS3).append(DOT)
                .append(TABLE_S1_CPU_FILEDS4).append(DOT)
                .append(TABLE_S1_CPU_FILEDS5).append(DOT)
                .append(TABLE_S1_CPU_FILEDS6).append(DOT)
                .append(TABLE_S1_CPU_FILEDS7).append(DOT)
                .append(TABLE_S1_CPU_FILEDS8).append(DOT)
                .append(TABLE_S1_CPU_FILEDS9).append(DOT)
                .append(TABLE_S1_CPU_FILEDS10).append(DOT)
                .append(TABLE_S1_CPU_FILEDS11).append(DOT)
                .append(TABLE_S1_CPU_FILEDS12).append(DOT)
                .append(TABLE_S1_CPU_FILEDS13);
        sbValues.append(TRANSFER).append(bean.getTime()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getIp()).append(TRANSFER).append(DOT)
                .append(bean.getCpu_number()).append(DOT)
                .append(bean.getCpu_clock()).append(DOT)
                .append(TRANSFER).append(bean.getCpu_producer()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getCpu_classfication()).append(TRANSFER).append(DOT)
                .append(bean.getCpu_cache()).append(DOT)
                .append(bean.getCpu_userusedrate()).append(DOT)
                .append(bean.getCpu_sysusedrate()).append(DOT)
                .append(bean.getCpu_currentwaitingrate()).append(DOT)
                .append(bean.getCpu_currenterrorrate()).append(DOT)
                .append(bean.getCpu_currentfreerate()).append(DOT)
                .append(bean.getCpu_allusedrate());
        addSQLBatch(TABLE_SERVER_CPU, sbKeys, sbValues, statement);
    }

    public static void insertTableDisc(BeanTable_Server1Disc bean, Statement statement) throws SQLException {
        StringBuffer sbKeys = new StringBuffer();
        StringBuffer sbValues = new StringBuffer();
        sbKeys.append(TABLE_S1_DISC_FILEDS1).append(DOT)
                .append(TABLE_S1_DISC_FILEDS2).append(DOT)
                .append(TABLE_S1_DISC_FILEDS3).append(DOT)
                .append(TABLE_S1_DISC_FILEDS4).append(DOT)
                .append(TABLE_S1_DISC_FILEDS5).append(DOT)
                .append(TABLE_S1_DISC_FILEDS6).append(DOT)
                .append(TABLE_S1_DISC_FILEDS7).append(DOT)
                .append(TABLE_S1_DISC_FILEDS8).append(DOT)
                .append(TABLE_S1_DISC_FILEDS9).append(DOT)
                .append(TABLE_S1_DISC_FILEDS10).append(DOT)
                .append(TABLE_S1_DISC_FILEDS11).append(DOT)
                .append(TABLE_S1_DISC_FILEDS12).append(DOT)
                .append(TABLE_S1_DISC_FILEDS13);
        sbValues.append(TRANSFER).append(bean.getTime()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getIp()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getDisc_name()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(UtilString.helpTransfor(bean.getDisc_lettername())).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(UtilString.helpTransfor(bean.getDisc_letterpath())).append(TRANSFER).append(DOT)
                .append(bean.getDisc_lettersymbol()).append(DOT)
                .append(TRANSFER).append(bean.getDisc_letterclassfication()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getDisc_letterclassficationname()).append(TRANSFER).append(DOT)
                .append(bean.getDisc_letterfilesysficationname()).append(DOT)
                .append(bean.getDisc_allsize()).append(DOT)
                .append(bean.getDisc_free()).append(DOT)
                .append(bean.getDisc_used()).append(DOT)
                .append(bean.getDisc_utilization());
        addSQLBatch(TABLE_SERVER_DISC, sbKeys, sbValues, statement);
    }

    public static void insertTableMemNet(BeanTable_Server1MemNet bean, Statement statement) throws SQLException {
        StringBuffer sbKeys = new StringBuffer();
        StringBuffer sbValues = new StringBuffer();
        sbKeys.append(TABLE_S1_MEMNET_FILEDS1).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS2).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS3).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS4).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS5).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS6).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS7).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS8).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS9).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS10).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS11).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS12).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS13).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS14).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS15).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS16).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS17).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS18).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS19).append(DOT)
                .append(TABLE_S1_MEMNET_FILEDS20);
        sbValues.append(TRANSFER).append(bean.getTime()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getIp()).append(TRANSFER).append(DOT)
                .append(bean.getMem_usedpercent()).append(DOT)
                .append(bean.getMem_allsize()).append(DOT)
                .append(bean.getMem_currentused()).append(DOT)
                .append(bean.getMem_currentrested()).append(DOT)
                .append(bean.getMem_swapall()).append(DOT)
                .append(bean.getMem_swapcurrentused()).append(DOT)
                .append(bean.getMem_swapcurrentrested()).append(DOT)
                .append(TRANSFER).append(bean.getNet_devname()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getNet_ip()).append(TRANSFER).append(DOT)
                .append(TRANSFER).append(bean.getNet_netmask()).append(TRANSFER).append(DOT)
                .append(bean.getNet_recpackages()).append(DOT)
                .append(bean.getNet_sentpackages()).append(DOT)
                .append(bean.getNet_recbytes()).append(DOT)
                .append(bean.getNet_sentbytes()).append(DOT)
                .append(bean.getNet_recerrorpackages()).append(DOT)
                .append(bean.getNet_senterrorpackages()).append(DOT)
                .append(bean.getNet_recabandonedpackages()).append(DOT)
                .append(bean.getNet_sentabandonedpackages());
        addSQLBatch(TABLE_SERVER_MEMNET, sbKeys, sbValues, statement);
    }


    public static void main(String[] args) {
           DBHelper.getConnection();
//        try {
//            insertAction();
//        } catch (SigarException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
