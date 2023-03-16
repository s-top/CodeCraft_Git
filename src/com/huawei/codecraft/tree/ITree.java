package com.huawei.codecraft.tree;

import com.huawei.codecraft.constant.NodeStatus;

/**
 * 行为树接口基类
 */
public interface ITree {

    /**
     * 流程
     */
    NodeStatus process();

    /**
     * 初始化
     */
    void init();

    /**
     * 更新
     */
    NodeStatus update();

    /**
     * 释放
     */
    void release();

    /**
     * 添加子节点
     */
    void addChild(ITree child);

    /**
     * 终止
     */
    void terminate(NodeStatus nodeStatus);

    /**
     * 设置状态
     */
    void setStatus(NodeStatus status);

    /**
     * 获取状态
     */
    NodeStatus getStatus();

    void reset();

    void abort();
}
