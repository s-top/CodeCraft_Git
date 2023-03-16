package com.huawei.codecraft.role;

/**
 * 机器人
 */
public class Robot extends BaseRole {

    /**
     * 所处工作台 ID
     * -1：表示当前没有处于任何工作台附近
     * [0,工作台总数-1]
     */
    protected int workbenchId;

    /**
     * 携带物品类型，范围[0,7]
     */
    protected int product;

    /**
     * 时间价值系数
     */
    protected float timeParam;

    /**
     * 碰撞价值系数
     */
    protected float collideParam;

    /**
     * 角速度
     * 正数：表示逆时针
     * 负数：表示顺时针
     */
    protected float angularSpeed;

    /**
     * 线速度
     */
    protected Point lineSpeed;

    /**
     * 朝向
     * 弧度，范围[-π,π] 方向示例：
     * 0：表示右方向
     * π/2：表示上方向
     * -π/2：表示下方向
     */
    protected float forward;

    public int getWorkbenchId() {
        return workbenchId;
    }

    public void setWorkbenchId(int workbenchId) {
        this.workbenchId = workbenchId;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public float getTimeParam() {
        return timeParam;
    }

    public void setTimeParam(float timeParam) {
        this.timeParam = timeParam;
    }

    public float getCollideParam() {
        return collideParam;
    }

    public void setCollideParam(float collideParam) {
        this.collideParam = collideParam;
    }

    public float getAngularSpeed() {
        return angularSpeed;
    }

    public void setAngularSpeed(float angularSpeed) {
        this.angularSpeed = angularSpeed;
    }

    public Point getLineSpeed() {
        return lineSpeed;
    }

    public void setLineSpeed(Point lineSpeed) {
        this.lineSpeed = lineSpeed;
    }

    public float getForward() {
        return forward;
    }

    public void setForward(float forward) {
        this.forward = forward;
    }

    @Override
    public String toString() {
        return "Robot{" + "id=" + id + ", workbenchId=" + workbenchId +
                "product=" + product + "timeParam=" + timeParam + "collideParam=" + collideParam +
                "angularSpeed=" + angularSpeed + "lineSpeed=" + lineSpeed + "point=" + point + "}";
    }
}
