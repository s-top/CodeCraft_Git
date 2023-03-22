package com.huawei.codecraft.tree.impl.action;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.action.ActionBuilder;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseAction;

public class ActionBuy extends BaseAction {

    MainContent mainContent;

    StringBuilder builder;

    public ActionBuy(MainContent mainContent, StringBuilder builder) {
        this.mainContent = mainContent;
        this.builder = builder;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent || null == builder) {
            return NodeStatus.Failure;
        }
        Robot r = mainContent.getRobots().stream().filter(robot -> robot.getId() == 0).findFirst().orElse(null);
        if (r.getProduct() == 0) {
            builder.append(ActionBuilder.buyAction(r.getId()));
            return NodeStatus.Success;
        }
        return NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {

    }
}
