package com.huawei.codecraft;

public class MainContent {
    /**
     * 初始化地图结束标记
     */
    private boolean initMapEnd = false;

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
}
