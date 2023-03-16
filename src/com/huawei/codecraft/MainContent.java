package com.huawei.codecraft;

import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;

import java.util.List;

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
