package com.huawei.codecraft.tree.impl.condition;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseCondition;
import com.huawei.codecraft.utils.StrategyUtil;

public class ConditionOutOfMap extends BaseCondition {

    MainContent mainContent;

    int rId;

    public ConditionOutOfMap(MainContent mainContent, int rId) {
        this.mainContent = mainContent;
        this.rId = rId;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent) {
            return NodeStatus.Failure;
        }
        Robot r = mainContent.getRobots().stream()
                .filter(robot -> robot.getId() == rId)
                .findFirst()
                .orElse(null);
        return StrategyUtil.pointOutOfMap(r.getPoint()) ? NodeStatus.Success : NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {
    }

}
