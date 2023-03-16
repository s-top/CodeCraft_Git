package com.huawei.codecraft.action;

import com.huawei.codecraft.constant.ActionType;
import com.huawei.codecraft.constant.Constants;

/**
 * 动作基类
 */
public class ActionBuilder {

    /**
     * 前进
     */
    public static String forwardAction(int robotId, float speed) {
        return ActionType.forward + Constants.Global.WHITE_SPACE + robotId +
                Constants.Global.WHITE_SPACE + speed + Constants.Global.LINE_BREAK;
    }

    /**
     * 旋转
     */
    public static String rotateAction(int robotId, float speed) {
        return ActionType.rotate + Constants.Global.WHITE_SPACE + robotId +
                Constants.Global.WHITE_SPACE + speed + Constants.Global.LINE_BREAK;
    }

    /**
     * 购买
     */
    public static String buyAction(int robotId) {
        return ActionType.buy + Constants.Global.WHITE_SPACE + robotId + Constants.Global.LINE_BREAK;
    }

    /**
     * 出售
     */
    public static String sellAction(int robotId) {
        return ActionType.sell + Constants.Global.WHITE_SPACE + robotId + Constants.Global.LINE_BREAK;
    }

    /**
     * 销毁
     */
    public static String destroyAction(int robotId) {
        return ActionType.destroy + Constants.Global.WHITE_SPACE + robotId + Constants.Global.LINE_BREAK;
    }
}
