package com.huawei.codecraft.tree.nodes;

import com.huawei.codecraft.tree.ITree;

/**
 * 条件节点基类
 */
public interface ICondition extends ITree {

    boolean isNegation();

    void setNegation(boolean negation);
}
