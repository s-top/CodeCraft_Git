package com.huawei.codecraft;

import com.huawei.codecraft.utils.LogUtil;

import java.io.*;

public class Main {

    private static final BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));

    private static final PrintStream outStream = new PrintStream(new BufferedOutputStream(System.out), true);

    private static MainContent mainContent = new MainContent();

    public static void main(String[] args) throws IOException {
        schedule();
    }

    private static void schedule() throws IOException {
        readUtilOK(0);
        outStream.print("OK\n");
        int frameID;
        String line;
        while ((line = inStream.readLine()) != null) {
            String[] parts = line.split(" ");
            frameID = Integer.parseInt(parts[0]);
            readUtilOK(frameID);

            // 构造输出结果
            StringBuilder builder = new StringBuilder();
            builder.append(frameID).append('\n');
            int lineSpeed = 3;
            double angleSpeed = 1.5;
            for (int robotId = 0; robotId < 4; robotId++) {
                builder.append("forward").append(' ').append(robotId).append(' ').append(lineSpeed).append('\n');
                builder.append("rotate").append(' ').append(robotId).append(' ').append(angleSpeed).append('\n');
            }
            builder.append("OK").append('\n');
            outStream.print(builder);
        }
    }

    private static boolean readUtilOK(int frameID) throws IOException {
        // 记录单个回合数据
        StringBuilder roundData = new StringBuilder();
        String line;
        while ((line = inStream.readLine()) != null) {
            // 初始化地图结束标记
            if (101 == frameID) {
                mainContent.setInitMapEnd(true);
            }
            if ("OK".equals(line)) {
                // 记录单个回合数据到全局变量
                if (mainContent.isInitMapEnd()) {
                    mainContent.setRoundData(roundData.toString());
                    // LogUtil.writeLog(mainContent.getRoundData());
                }
                return true;
            }
            // 拼接单个回合数据
            if (mainContent.isInitMapEnd()) {
                roundData.append(line).append("\n");
            }
        }
        return false;
    }
}
