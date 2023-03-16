package com.huawei.codecraft.tree.impl;

import com.huawei.codecraft.tree.ITree;

public class BTree {
    private ITree root;

    public BTree(ITree root) {
        this.root = root;
    }

    public void process() {
        root.process();
    }

    public boolean haveRoot() {
        return root != null ? true : false;
    }

    public void setRoot(ITree inNode) {
        root = inNode;
    }

    public void release() {
        root.release();
    }

}