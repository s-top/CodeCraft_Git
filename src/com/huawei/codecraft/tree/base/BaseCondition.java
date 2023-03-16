package com.huawei.codecraft.tree.base;

import com.huawei.codecraft.tree.nodes.ICondition;

public abstract class BaseCondition extends BaseTree implements ICondition {
    protected boolean negation = false;

    @Override
    public boolean isNegation() {
        return negation;
    }

    @Override
    public void setNegation(boolean negation) {
        this.negation = negation;
    }

    protected int getRandom() {
        Double random = Math.random() * 100;
        //    int i = random.intValue();
        return random.intValue();
    }
}
