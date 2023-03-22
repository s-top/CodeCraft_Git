package com.huawei.codecraft.utils;

import com.huawei.codecraft.action.ActionBuilder;
import com.huawei.codecraft.constant.Constants;
import com.huawei.codecraft.role.Point;
import com.huawei.codecraft.role.Robot;

/**
 * 解析工具类
 */
public class StrategyUtil {

    public static void moveToTarget(Robot r, StringBuilder builder, Point target) {
        int quadrant = r.getPoint().getQuardrant(target);
        if (quadrant == 12) {
            moveTo12Target(r, builder, target);
        } else {
            moveTo34Target(r, builder, target);
        }
    }

    private static void moveTo12Target(Robot r, StringBuilder builder, Point target) {
        float degree = r.getPoint().getRotate(target);
        if (isEqualIntZero(r.getAngularSpeed(), Constants.Point.FLOAT_ZERO)) {
            // 微调角度，区分象限
            if (isMoreThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.STEP_FU));
            } else if (isLessThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.STEP_ZHENG));
            }
        } else {
            // 粗调角度，区分象限
            if (isMoreThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.INT_ZERO));
            } else if (isLessThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), degree - r.getForward()));
            }
        }
        builder.append(ActionBuilder.forwardAction(r.getId(),
                Math.min(r.getPoint().getDistance(target), Constants.Point.DEFAULT_SPEED)));
    }

    private static void moveTo34Target(Robot r, StringBuilder builder, Point target) {
        float degree = r.getPoint().getRotate(target);
        if (isEqualIntZero(r.getAngularSpeed(), Constants.Point.FLOAT_ZERO)) {
            // 微调角度，区分象限
            if (isMoreThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.STEP_FU));
            } else if (isLessThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.STEP_ZHENG));
            }
        } else {
            // 粗调角度，区分象限
            if (isLessThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.INT_ZERO));
            } else if (isMoreThanIntZero(r.getForward(), degree)) {
                builder.append(ActionBuilder.rotateAction(r.getId(), degree - r.getForward()));
            }
        }
        builder.append(ActionBuilder.forwardAction(r.getId(),
                Math.min(r.getPoint().getDistance(target), Constants.Point.DEFAULT_SPEED)));
    }

    private static boolean isEqualIntZero(float a, float b) {
        return Float.compare(a, b) == Constants.Point.INT_ZERO;
    }

    private static boolean isMoreThanIntZero(float a, float b) {
        return Float.compare(a, b) > Constants.Point.INT_ZERO;
    }

    private static boolean isLessThanIntZero(float a, float b) {
        return Float.compare(a, b) < Constants.Point.INT_ZERO;
    }
}
