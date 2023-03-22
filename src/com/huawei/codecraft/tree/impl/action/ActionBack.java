package com.huawei.codecraft.tree.impl.action;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseAction;
import com.huawei.codecraft.utils.StrategyUtil;

public class ActionBack extends BaseAction {

    MainContent mainContent;

    StringBuilder builder;

    public ActionBack(MainContent mainContent, StringBuilder builder) {
        this.mainContent = mainContent;
        this.builder = builder;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent || null == builder) {
            return NodeStatus.Failure;
        }
        Workbench w = mainContent.getWorkbenches().stream().filter(workbench -> workbench.getId() == 5).findFirst().orElse(null);
        Robot r = mainContent.getRobots().stream().filter(robot -> robot.getId() == 0).findFirst().orElse(null);
        StrategyUtil.moveToTarget(r, builder, w.getPoint());
        return NodeStatus.Success;
    }

    @Override
    public void addChild(ITree child) {

    }
}
