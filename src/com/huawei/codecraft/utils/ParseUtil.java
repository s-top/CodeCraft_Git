package com.huawei.codecraft.utils;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.Constants;
import com.huawei.codecraft.entry.AvailbleWorkInfo;
import com.huawei.codecraft.role.Point;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            workbench.setIndex(i - 1);
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
            robot.setTimeParam(Float.parseFloat(row[Constants.Robot.INDEX_TIME]));
            robot.setCollideParam(Float.parseFloat(row[Constants.Robot.INDEX_COLLIDE]));
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

        // 解析机器人到各点距离
        initRobotAndWorkInfosMap(mainContent);
    }

    private static void initRobotAndWorkInfosMap(MainContent mainContent) {
        Map<String, List<AvailbleWorkInfo>> robotAndWorkInfosMap = new HashMap<>();
        List<Robot> robots = mainContent.getRobots();
        List<Workbench> workbenches = mainContent.getWorkbenches();
        for (Map.Entry<Integer, List<Integer>> entry : mainContent.getrIdAndWids().entrySet()) {
            int robotId = entry.getKey();
            List<Integer> workIds = entry.getValue();
            Robot robot = robots.stream()
                    .filter(r -> r.getId() == robotId)
                    .findFirst()
                    .orElse(null);
            List<Workbench> workbenchList = workbenches.stream()
                    .filter(w -> workIds.contains(w.getId()))
                    .collect(Collectors.toList());
            buildRobotIdAndAvailbleWorkInfosMap(robot, workbenchList, robotAndWorkInfosMap);
        }
        mainContent.setRobotAndWorkInfosMap(robotAndWorkInfosMap);
    }

    private static void buildRobotIdAndAvailbleWorkInfosMap(Robot robot, List<Workbench> workbenchList,
        Map<String, List<AvailbleWorkInfo>> robotAndWorkInfosMap) {
        for (Workbench w : workbenchList) {
            AvailbleWorkInfo a = new AvailbleWorkInfo();
            a.setrId(robot.getId());
            a.setwId(w.getId());
            a.setwIndex(w.getIndex());
            a.setrPoint(robot.getPoint());
            a.setwPoint(w.getPoint());
            a.setDistance(robot.getPoint().getDistance(w.getPoint()));
            String id = robot.getId() + Constants.Global.UNDER_LINE + w.getId();
            if (robotAndWorkInfosMap.containsKey(id)) {
                List<AvailbleWorkInfo> availbleWorkInfos = robotAndWorkInfosMap.get(id);
                availbleWorkInfos.add(a);
            } else {
                List<AvailbleWorkInfo> availbleWorkInfos = new ArrayList<>();
                availbleWorkInfos.add(a);
                robotAndWorkInfosMap.put(id, availbleWorkInfos);
            }
        }
    }
}
