package com.huawei.codecraft.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 日志工具类
 */
public class LogUtil {

    /**
     * 用于调试打印日志到本地文件
     */
    public static void writeLog(String logValue) {
        FileWriter fw = null;
        try {
            File f = new File("D:\\log.txt");
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(logValue);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
