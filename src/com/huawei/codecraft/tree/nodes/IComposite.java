package com.huawei.codecraft.tree.nodes;

import com.huawei.codecraft.tree.ITree;

import java.util.List;

/**
 * 组合节点基类
 */
public interface IComposite extends ITree {

    void addChild(ITree child);

    void removeChild(ITree child);

    void clearChild();

    List<ITree> getChildren();

    void setChildren(List<ITree> behaviours);

}