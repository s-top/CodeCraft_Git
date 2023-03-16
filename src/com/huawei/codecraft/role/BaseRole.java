package com.huawei.codecraft.role;

/**
 * 角色基类
 */
public abstract class BaseRole {
    protected int id;

    protected Point point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
