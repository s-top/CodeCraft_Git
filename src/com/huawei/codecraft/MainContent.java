package com.huawei.codecraft;

import com.huawei.codecraft.entry.AvailbleWorkInfo;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;

import java.util.*;

public class MainContent {
    /**
     * 初始化地图结束标记
     */
    private boolean initMapEnd = false;

    /**
     * 工作台个数
     */
    private int workbenchNum;

    /**
     * 工作台信息
     */
    private List<Workbench> workbenches;

    /**
     * 机器人信息
     */
    private List<Robot> robots;

    /**
     * 单个回合数据
     */
    private String roundData;

    Map<String, List<AvailbleWorkInfo>> robotAndWorkInfosMap;

    Map<String, List<AvailbleWorkInfo>> productAndWorkInfoMap;

    Map<Integer, AvailbleWorkInfo> rIdAndAvailbleWorkInfoMap = new HashMap<>();

    Map<Integer, List<Integer>> rIdAndWids = new HashMap<>();

    {
        rIdAndWids.put(0, Collections.singletonList(1));
        rIdAndWids.put(1, Arrays.asList(2, 3));
        rIdAndWids.put(2, Arrays.asList(4, 5, 6));
        rIdAndWids.put(3, Collections.singletonList(7));
    }

    Map<Integer, List<Integer>> pIdAndWids = new HashMap<>();

    {
        pIdAndWids.put(1, Arrays.asList(4, 5, 9));
        pIdAndWids.put(2, Arrays.asList(4, 6, 9));
        pIdAndWids.put(3, Arrays.asList(5, 6, 9));
        pIdAndWids.put(4, Arrays.asList(7, 9));
        pIdAndWids.put(5, Arrays.asList(7, 9));
        pIdAndWids.put(6, Arrays.asList(7, 9));
        pIdAndWids.put(7, Arrays.asList(9, 9));
    }

    public Map<String, List<AvailbleWorkInfo>> getRobotAndWorkInfosMap() {
        return robotAndWorkInfosMap;
    }

    public void setRobotAndWorkInfosMap(Map<String, List<AvailbleWorkInfo>> robotAndWorkInfosMap) {
        this.robotAndWorkInfosMap = robotAndWorkInfosMap;
    }

    public Map<Integer, AvailbleWorkInfo> getrIdAndAvailbleWorkInfoMap() {
        return rIdAndAvailbleWorkInfoMap;
    }

    public void setrIdAndAvailbleWorkInfoMap(Map<Integer, AvailbleWorkInfo> rIdAndAvailbleWorkInfoMap) {
        this.rIdAndAvailbleWorkInfoMap = rIdAndAvailbleWorkInfoMap;
    }

    public Map<String, List<AvailbleWorkInfo>> getProductAndWorkInfoMap() {
        return productAndWorkInfoMap;
    }

    public void setProductAndWorkInfoMap(Map<String, List<AvailbleWorkInfo>> productAndWorkInfoMap) {
        this.productAndWorkInfoMap = productAndWorkInfoMap;
    }

    public Map<Integer, List<Integer>> getrIdAndWids() {
        return rIdAndWids;
    }

    public Map<Integer, List<Integer>> getpIdAndWids() {
        return pIdAndWids;
    }

    public boolean isInitMapEnd() {
        return initMapEnd;
    }

    public void setInitMapEnd(boolean initMapEnd) {
        this.initMapEnd = initMapEnd;
    }

    public String getRoundData() {
        return roundData;
    }

    public void setRoundData(String roundData) {
        this.roundData = roundData;
    }

    public int getWorkbenchNum() {
        return workbenchNum;
    }

    public void setWorkbenchNum(int workbenchNum) {
        this.workbenchNum = workbenchNum;
    }

    public List<Workbench> getWorkbenches() {
        return workbenches;
    }

    public void setWorkbenches(List<Workbench> workbenches) {
        this.workbenches = workbenches;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }
}
