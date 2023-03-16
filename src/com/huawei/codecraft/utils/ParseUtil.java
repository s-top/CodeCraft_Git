package com.huawei.codecraft.utils;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.Constants;
import com.huawei.codecraft.role.Point;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析工具类
 */
public class ParseUtil {

    public static void initMapContentByRoundData(MainContent mainContent) {
        String roundData = mainContent.getRoundData();
        // 按照换行符分割
        String[] rows = roundData.split(Constants.Global.LINE_BREAK);
        int workbenchNum = Integer.parseInt(rows[Constants.Workbench.ROUND_INDEX]);
        mainContent.setWorkbenchNum(workbenchNum);

        // 解析工作台数据，下标：1 ~ workbenchNum
        List<Workbench> workbenches = new ArrayList<>();
        for (int i = 1; i <= workbenchNum; i++) {
            String[] row = rows[i].split(Constants.Global.WHITE_SPACE);
            Workbench workbench = new Workbench();
            workbench.setId(Integer.parseInt(row[Constants.Workbench.INDEX_ID]));
            workbench.setPoint(new Point(Float.parseFloat(row[Constants.Workbench.INDEX_X]),
                    Float.parseFloat(row[Constants.Workbench.INDEX_Y])));
            workbench.setRemainTime(Integer.parseInt(row[Constants.Workbench.INDEX_RT]));
            workbench.setProductIn(Integer.parseInt(row[Constants.Workbench.INDEX_PIN]));
            workbench.setProductOut(Integer.parseInt(row[Constants.Workbench.INDEX_POUT]));
            workbenches.add(workbench);
        }
        mainContent.setWorkbenches(workbenches);

        // 解析机器人数据，下标：workbenchNum + 1 ~ workbenchNum + 机器人个数
        List<Robot> robots = new ArrayList<>();
        int robotIndex = Constants.Robot.DEFAULT_INDEX;
        for (int i = workbenchNum + 1; i <= workbenchNum + Constants.Robot.DEFAULT_NUM; i++) {
            String[] row = rows[i].split(Constants.Global.WHITE_SPACE);
            Robot robot = new Robot();
            robot.setId(robotIndex);
            robot.setWorkbenchId(Integer.parseInt(row[Constants.Robot.INDEX_WID]));
            robot.setProduct(Integer.parseInt(row[Constants.Robot.INDEX_P]));
            robot.setTimeParam(Integer.parseInt(row[Constants.Robot.INDEX_TIME]));
            robot.setCollideParam(Integer.parseInt(row[Constants.Robot.INDEX_COLLIDE]));
            robot.setAngularSpeed(Float.parseFloat(row[Constants.Robot.INDEX_AS]));
            robot.setLineSpeed(new Point(Float.parseFloat(row[Constants.Robot.INDEX_LS_X]),
                    Float.parseFloat(row[Constants.Robot.INDEX_LS_Y])));
            robot.setForward(Float.parseFloat(row[Constants.Robot.INDEX_F]));
            robot.setPoint(new Point(Float.parseFloat(row[Constants.Robot.INDEX_X]),
                    Float.parseFloat(row[Constants.Robot.INDEX_Y])));
            robots.add(robot);
            robotIndex++;
        }
        mainContent.setRobots(robots);
    }
}
