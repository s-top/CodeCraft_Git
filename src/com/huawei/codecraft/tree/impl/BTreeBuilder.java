package com.huawei.codecraft.tree.impl;

import com.huawei.codecraft.tree.ITree;

import java.util.Stack;

public class BTreeBuilder {
    private Stack<ITree> stack = new Stack<>();
    private ITree treeRoot = null;

    public BTreeBuilder addBehaviour(ITree behaviour) {
        if (treeRoot == null) {
            treeRoot = behaviour;
        } else {
            stack.peek().addChild(behaviour);
        }
        stack.push(behaviour);
        return this;
    }

    public BTreeBuilder back() {
        stack.pop();
        return this;
    }

    public BTree end() {
        while (!stack.empty()) {
            stack.pop();
        }
        BTree Tmp = new BTree(treeRoot);
        return Tmp;
    }

}