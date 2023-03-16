package com.huawei.codecraft.tree.base;

import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.nodes.IComposite;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComposite extends BaseTree implements IComposite {

    protected ArrayList<ITree> children = new ArrayList<>();

    @Override
    public void addChild(ITree child) {
        children.add(child);
    }

    @Override
    public void removeChild(ITree child) {
        children.remove(child);
    }

    @Override
    public void clearChild() {
        children.clear();
    }

    @Override
    public List<ITree> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<ITree> behaviours) {
        this.children = (ArrayList<ITree>) behaviours;
    }
}
