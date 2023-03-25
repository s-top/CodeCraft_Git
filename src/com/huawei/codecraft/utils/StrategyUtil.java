package com.huawei.codecraft.utils;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.action.ActionBuilder;
import com.huawei.codecraft.constant.Constants;
import com.huawei.codecraft.entry.AvailbleWorkInfo;
import com.huawei.codecraft.role.Point;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 解析工具类
 */
public class StrategyUtil {

    Map<Integer, List<Integer>> wIdAndProducts = new HashMap<>();

    {
        wIdAndProducts.put(4, Arrays.asList(1, 2));
        wIdAndProducts.put(5, Arrays.asList(1, 3));
        wIdAndProducts.put(6, Arrays.asList(2, 3));
        wIdAndProducts.put(7, Arrays.asList(4, 5, 6));
    }

    public static boolean productIsEmpty(int productId, Workbench w) {
        if (null == w || w.getProductIn() <= 0) {
            return true;
        }
        String productInStr = new StringBuilder(Integer.toBinaryString(w.getProductIn())).reverse().toString();
        if (productInStr.length() < productId + 1) {
            return false;
        }
        char value = productInStr.charAt(productId);
        switch (value) {
            case '1':
                return false;
            case '0':
            default:
                return true;
        }
    }

    public static void forwardToMap(Robot r, StringBuilder builder) {
        if (Float.compare(r.getPoint().x, Constants.Point.MAP_MIN_SIZE) <= 0) {
            StrategyUtil.rotateBackToMap(r, builder, (float) Math.PI);
            return;
        }
        if (Float.compare(r.getPoint().x, Constants.Point.MAP_MAX_SIZE) >= 0) {
            StrategyUtil.rotateBackToMap(r, builder, Constants.Point.FLOAT_ZERO);
            return;
        }
        if (Float.compare(r.getPoint().y, Constants.Point.MAP_MIN_SIZE) <= 0) {
            StrategyUtil.rotateBackToMap(r, builder, (float) (3 * Math.PI / 2));
            return;
        }
        if (Float.compare(r.getPoint().y, Constants.Point.MAP_MAX_SIZE) >= 0) {
            StrategyUtil.rotateBackToMap(r, builder, (float) (Math.PI / 2));
        }
    }

    public static boolean pointOutOfMap(Point p) {
        return Float.compare(p.x, Constants.Point.MAP_MIN_SIZE) <= 0
                || Float.compare(p.x, Constants.Point.MAP_MAX_SIZE) >= 0
                || Float.compare(p.y, Constants.Point.MAP_MIN_SIZE) <= 0
                || Float.compare(p.y, Constants.Point.MAP_MAX_SIZE) >= 0;
    }

    public static void rotateBackToMap(Robot r, StringBuilder builder, float degree) {
        float f = r.getForward();
        if (isLessThanIntZero(f, Constants.Point.FLOAT_ZERO)) {
            f = (float) (f + 2 * Math.PI);
        }
        if (isMoreThanIntZero(f, degree)) {
            builder.append(ActionBuilder.rotateAction(r.getId(), (float) Math.PI));
        } else if (isLessThanIntZero(f, degree)) {
            builder.append(ActionBuilder.rotateAction(r.getId(), (float) (-1 * Math.PI)));
        } else {
            builder.append(ActionBuilder.forwardAction(r.getId(), Constants.Point.DEFAULT_SPEED_FU));
            return;
        }
        builder.append(ActionBuilder.forwardAction(r.getId(), Constants.Point.DEFAULT_SPEED));
    }

    public static AvailbleWorkInfo getTheClosedWorkByRoleId(int rId, MainContent mainContent) {
        List<AvailbleWorkInfo> availbleWorkInfoList = new ArrayList<>();
        List<Integer> wIds = mainContent.getrIdAndWids().get(rId);
        for (Integer wId : wIds) {
            availbleWorkInfoList.addAll(mainContent.getRobotAndWorkInfosMap()
                    .get(rId + Constants.Global.UNDER_LINE + wId));
        }
        return availbleWorkInfoList.stream()
                .min(Comparator.comparing(AvailbleWorkInfo::getDistance))
                .orElse(null);
    }

    public static AvailbleWorkInfo getTheClosedWorkByProductId(Robot robot, MainContent mainContent) {
        List<AvailbleWorkInfo> availbleWorkInfoList = new ArrayList<>();
        List<Integer> wIds = mainContent.getpIdAndWids().get(robot.getProduct());
        List<Workbench> workbenches = mainContent.getWorkbenches().stream()
                .filter(w -> wIds.contains(w.getId()) && productIsEmpty(robot.getProduct(), w))
                .collect(Collectors.toList());
        workbenches.forEach(w -> {
            AvailbleWorkInfo a = new AvailbleWorkInfo();
            a.setwPoint(w.getPoint());
            a.setwIndex(w.getIndex());
            a.setrId(robot.getId());
            a.setDistance(robot.getPoint().getDistance(w.getPoint()));
            availbleWorkInfoList.add(a);
        });
        return availbleWorkInfoList.stream()
                .min(Comparator.comparing(AvailbleWorkInfo::getDistance))
                .orElse(null);
    }

    public static void moveToTarget(Robot r, StringBuilder builder, Point target) {
        float degree = r.getPoint().getQuardrant(target);
        float forward = r.getForward();
        if (isLessThanIntZero(forward, Constants.Point.FLOAT_ZERO)) {
            forward = (float) (forward + 2 * Math.PI);
        }
        // 粗调角度，区分象限
        if (Float.compare(Math.abs(forward - degree), Constants.Point.STEP_ZHENG) < 0) {
            builder.append(ActionBuilder.rotateAction(r.getId(), Constants.Point.FLOAT_ZERO));
            return;
        }
        if (isLessThanIntZero(forward, degree)) {
            builder.append(ActionBuilder.rotateAction(r.getId(), (float) Math.PI));
        }
        if (isMoreThanIntZero(forward, degree)) {
            builder.append(ActionBuilder.rotateAction(r.getId(), (float) (-1 * Math.PI)));
        }
        builder.append(ActionBuilder.forwardAction(r.getId(), Math.min(r.getPoint().getDistance(target) * 2,
                Constants.Point.DEFAULT_SPEED)));
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
