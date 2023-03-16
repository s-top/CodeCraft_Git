package com.huawei.codecraft.role;

/**
 * 工作台
 */
public class Workbench extends BaseRole {

    /**
     * 剩余生产时间
     * -1：表示没有生产
     * 0：表示生产因输出格满而阻塞
     * >=0：表示剩余生产帧数
     */
    protected int remainTime;

    /**
     * 原材料格状态
     * 二进制位表描述，例如 48(110000)
     * 表示拥有物品 4 和 5
     */
    protected int productIn;

    /**
     * 产品格状态
     * 0：表示无。
     * 1：表示有。
     */
    protected int productOut;

    public int getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    public int getProductIn() {
        return productIn;
    }

    public void setProductIn(int productIn) {
        this.productIn = productIn;
    }

    public int getProductOut() {
        return productOut;
    }

    public void setProductOut(int productOut) {
        this.productOut = productOut;
    }

    @Override
    public String toString() {
        return "Workbench{" + "id=" + id + ", point=" + point + ", remainTime=" + remainTime +
                ", productIn=" + productIn + ", productOut=" + productOut + "}";
    }
}
