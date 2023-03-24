package com.huawei.codecraft.tree.impl.condition;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.entry.AvailbleWorkInfo;
import com.huawei.codecraft.role.Robot;
import com.huawei.codecraft.role.Workbench;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseCondition;

public class ConditionGo extends BaseCondition {

    MainContent mainContent;

    int rId;

    public ConditionGo(MainContent mainContent, int rId) {
        this.mainContent = mainContent;
        this.rId = rId;
    }

    @Override
    public NodeStatus update() {
        if (null == mainContent) {
            return NodeStatus.Failure;
        }
        AvailbleWorkInfo a = mainContent.getrIdAndAvailbleWorkInfoMap().get(rId);
        if (null == a) {
            return NodeStatus.Failure;
        }
        return a.isGo() ? NodeStatus.Success : NodeStatus.Failure;
    }

    @Override
    public void addChild(ITree child) {
    }

}
