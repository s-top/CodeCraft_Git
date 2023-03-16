package com.huawei.codecraft.tree.base;

import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.tree.ITree;

public abstract class BaseTree implements ITree {

    protected NodeStatus status;

    protected BaseTree() {
        setStatus(NodeStatus.Init);
    }

    public NodeStatus process() {
        if (status != NodeStatus.Running) {
            init();
        }
        status = update();
        if (status != NodeStatus.Running) {
            terminate(status);
        }
        return status;
    }

    public void release() {
    }

    public void setStatus(NodeStatus status) {
        this.status = status;
    }

    public NodeStatus getStatus() {
        return status;
    }

    @Override
    public void init() {
    }

    @Override
    public void terminate(NodeStatus Status) {
    }

    @Override
    public void reset() {
        setStatus(NodeStatus.Init);
    }

    @Override
    public void abort() {
        terminate(NodeStatus.Terminated);
        setStatus(NodeStatus.Terminated);
    }
}