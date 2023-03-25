package com.huawei.codecraft.entry;

import com.huawei.codecraft.role.Point;

public class AvailbleWorkInfo {

    int rId;
    int wId;
    int wIndex;

    Point rPoint;
    Point wPoint;
    float distance;

    boolean isGo = false;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public int getwIndex() {
        return wIndex;
    }

    public void setwIndex(int wIndex) {
        this.wIndex = wIndex;
    }

    public Point getrPoint() {
        return rPoint;
    }

    public void setrPoint(Point rPoint) {
        this.rPoint = rPoint;
    }

    public Point getwPoint() {
        return wPoint;
    }

    public void setwPoint(Point wPoint) {
        this.wPoint = wPoint;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isGo() {
        return isGo;
    }

    public void setGo(boolean go) {
        isGo = go;
    }

    @Override
    public String toString() {
        return "AvailbleWorkInfo{" + "rId=" + rId + ", wId=" + wId + ", wIndex=" + wIndex
                + ", rPoint=" + rPoint + ", wPoint=" + wPoint + ", distance=" + distance + ", isGo=" + isGo + "}";
    }
}
