package com.huawei.codecraft.tree.base;

import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.nodes.IDecorator;

public abstract class BaseDecorator extends BaseTree implements IDecorator {

    protected ITree child;

    @Override
    public void addChild(ITree child) {
        this.child = child;
    }

}
