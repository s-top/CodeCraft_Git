package com.huawei.codecraft.tree.impl.condition;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseCondition;

public class ConditionHasArrived extends BaseCondition {

    MainContent mainContent;

    int wId;

    public ConditionHasArrived(MainContent mainContent, int wId) {
        this.mainContent = mainContent;
        this.wId = wId;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent) {
            return NodeStatus.Failure;
        }
        Workbench w = mainContent.getWorkbenches().stream().filter(workbench -> workbench.getId() == wId).findFirst().orElse(null);
        Robot r = mainContent.getRobots().stream().filter(robot -> robot.getId() == 0).findFirst().orElse(null);
        if (wId == 5) {
            return r.getWorkbenchId() == 10 ? NodeStatus.Success : NodeStatus.Failure;
        }
        return r.getWorkbenchId() == (w.getId() - 1) ? NodeStatus.Success : NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {
    }

}
