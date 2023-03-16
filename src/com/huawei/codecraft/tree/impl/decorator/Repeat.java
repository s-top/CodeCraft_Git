package com.huawei.codecraft.tree.impl.decorator;

import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseDecorator;

public class Repeat extends BaseDecorator {

    private int limited = 3;
    private volatile int count = 0;

    @Override
    public NodeStatus update() {
        while (true) {
            child.process();
            switch (child.getStatus()) {
                case Running:
                    return NodeStatus.Success;
                case Failure:
                    return NodeStatus.Failure;
                default:
                    break;
            }
            if (++count > limited)
                return NodeStatus.Success;
            child.reset();
        }
    }

    @Override
    public void init() {
        count = 0;
    }

    @Override
    public void addChild(ITree child) {
        super.addChild(child);
    }
}
