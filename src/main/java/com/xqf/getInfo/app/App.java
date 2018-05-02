package com.xqf.getInfo.app;

import com.xqf.getInfo.db.DBHelper;
import org.hyperic.sigar.SigarException;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述:
 *
 * @author xqf
 * @create 2018-04-18 14:28
 */
class MyTimerTask extends TimerTask {

    public void run() {
        try {
            DBHelper.insertAction();//插入数据
        } catch (SigarException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class App {

    public static void main(String[] args) {
        Timer myTimer = new Timer();
        myTimer.schedule(new MyTimerTask(), 1000,1000);
    }
}