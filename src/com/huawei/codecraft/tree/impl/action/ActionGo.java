package com.huawei.codecraft.tree.impl.action;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.entry.AvailbleWorkInfo;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseAction;
import com.huawei.codecraft.utils.LogUtil;
import com.huawei.codecraft.utils.StrategyUtil;

public class ActionGo extends BaseAction {

    MainContent mainContent;

    StringBuilder builder;

    int rId;

    public ActionGo(MainContent mainContent, StringBuilder builder, int rId) {
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
                .findFirst().orElse(null);
        if (r.getProduct() == 0) {
            AvailbleWorkInfo a = mainContent.getrIdAndAvailbleWorkInfoMap().get(rId);
            if (null == a) {
                a = StrategyUtil.getTheClosedWorkByRoleId(r.getId(), mainContent);
            }
            if (null == a) {
                return NodeStatus.Failure;
            }
            a.setrPoint(r.getPoint());
            a.setDistance(r.getPoint().getDistance(a.getwPoint()));
            a.setGo(true);

            // 移动
            StrategyUtil.moveToTarget(r, builder, a.getwPoint());

            // 填充目标点
            mainContent.getrIdAndAvailbleWorkInfoMap().put(rId, a);
            return NodeStatus.Success;
        }
        return NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {

    }
}
