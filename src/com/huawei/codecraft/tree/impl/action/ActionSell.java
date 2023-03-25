package com.huawei.codecraft.tree.impl.action;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.action.ActionBuilder;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseAction;
import com.huawei.codecraft.utils.LogUtil;
import sun.rmi.runtime.Log;

public class ActionSell extends BaseAction {

    MainContent mainContent;

    StringBuilder builder;

    int rId;

    public ActionSell(MainContent mainContent, StringBuilder builder, int rId) {
        this.mainContent = mainContent;
        this.builder = builder;
        this.rId = rId;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent || null == builder) {
            return NodeStatus.Failure;
        }
        Robot r = mainContent.getRobots().stream()
                .filter(robot -> robot.getId() == rId)
                .findFirst()
                .orElse(null);
        if (r.getProduct() != 0) {
            builder.append(ActionBuilder.sellAction(r.getId()));

            // 目标点设置为空
            mainContent.getrIdAndAvailbleWorkInfoMap().put(rId, null);
            return NodeStatus.Success;
        }
        return NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {

    }
}
