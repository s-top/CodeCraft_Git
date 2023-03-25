package com.huawei.codecraft.role;

import com.huawei.codecraft.constant.Constants;

/**
 * 坐标
 */
public class Point {

    public float x;
    public float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Point) {
            Point c = (Point) obj;
            return x == c.x && y == c.y;
        }
        return false;
    }

    /**
     * 获取距离
     */
    public float getDistance(Point p) {
        if (p == null) {
            return 0;
        }
        float distanceX = this.x - p.x;
        float distanceY = this.y - p.y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    /**
     * 获取角度
     */
    public float getRotate(Point p) {
        if (p == null) {
            return 0;
        }
        float distanceX = p.x - this.x;
        float distanceY = p.y - this.y;
        return (float) Math.atan2(distanceY, distanceX);
    }

    /**
     * 获取象限
     */
    public float getQuardrant(Point p) {
        if (p == null) {
            return Constants.Point.FLOAT_ZERO;
        }
        float distanceX = p.x - this.x;
        float distanceY = p.y - this.y;
        return (float) Math.atan2(distanceY, distanceX);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + "}";
    }
}
