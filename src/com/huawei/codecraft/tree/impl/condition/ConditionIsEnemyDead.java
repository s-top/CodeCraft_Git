package com.huawei.codecraft.tree.impl.condition;

import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseCondition;

public class ConditionIsEnemyDead extends BaseCondition {

    public ConditionIsEnemyDead(boolean b) {
        setNegation(b);
    }

    @Override
    public NodeStatus update() {
        int random = getRandom();
        if (random < 60) {
            System.out.println("Enemy Is Dead");
            return !isNegation() ? NodeStatus.Success : NodeStatus.Failure;
        } else {
            System.out.println("Enemy is Not Dead");
            return !isNegation() ? NodeStatus.Failure : NodeStatus.Success;
        }
    }

    @Override
    public void addChild(ITree child) {
    }

}
