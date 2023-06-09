package com.huawei.codecraft.tree.impl.condition;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseCondition;

public class ConditionHasArrived extends BaseCondition {

    MainContent mainContent;

    int rId;

    public ConditionHasArrived(MainContent mainContent, int rId) {
        this.mainContent = mainContent;
        this.rId = rId;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent) {
            return NodeStatus.Failure;
        }
        if (null == mainContent.getrIdAndAvailbleWorkInfoMap().get(rId)) {
            return NodeStatus.Failure;
        }
        Robot r = mainContent.getRobots().stream()
                .filter(robot -> robot.getId() == rId)
                .findFirst()
                .orElse(null);
        return r.getWorkbenchId() == mainContent.getrIdAndAvailbleWorkInfoMap()
                .get(rId).getwIndex()
                ? NodeStatus.Success
                : NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {
    }

}
