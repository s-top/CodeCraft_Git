package com.huawei.codecraft.constant;

/**
 * 常量类
 */
public interface Constants {
    /**
     * 全局变量
     */
    interface Global {

        int MAP_SIZE = 100;

        String LINE_BREAK = "\n";

        String WHITE_SPACE = " ";

    }

    /**
     * 机器人
     */
    interface Robot {

        /**
         * 机器人默认个数
         */
        int DEFAULT_NUM = 4;

        /**
         * 机器人ID默认下标
         */
        int DEFAULT_INDEX = 0;

        int INDEX_WID = 0;
        int INDEX_P = 1;
        int INDEX_TIME = 2;
        int INDEX_COLLIDE = 3;
        int INDEX_AS = 4;
        int INDEX_LS_X = 5;
        int INDEX_LS_Y = 6;
        int INDEX_F = 7;
        int INDEX_X = 8;
        int INDEX_Y = 9;

    }

    /**
     * 工作台
     */
    interface Workbench {
        /**
         * 单个回合数据工作台个数下标
         */
        int ROUND_INDEX = 0;

        int INDEX_ID = 0;
        int INDEX_X = 1;
        int INDEX_Y = 2;
        int INDEX_RT = 3;
        int INDEX_PIN = 4;
        int INDEX_POUT = 5;
    }
}
