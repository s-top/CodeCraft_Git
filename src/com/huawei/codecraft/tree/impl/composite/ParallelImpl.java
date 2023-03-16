package com.huawei.codecraft.tree.impl.composite;

import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.constant.Policy;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseComposite;
import com.huawei.codecraft.tree.composite.IParallel;

public class ParallelImpl extends BaseComposite implements IParallel {

    Policy successPolocy;
    Policy failPolocy;

    public ParallelImpl(Policy successPolocy, Policy failPolocy) {
        this.successPolocy = successPolocy;
        this.failPolocy = failPolocy;
    }

    @Override
    public NodeStatus update() {
        int successCount = 0, failureCount = 0;
        int childrenSize = getChildren().size();
        for (ITree iBehaviour : getChildren()) {
            //如果行为已经终止则不再执行该行为
            if (!(iBehaviour.getStatus().equals(NodeStatus.Success) || iBehaviour.getStatus().equals(NodeStatus.Failure)))
                iBehaviour.process();

            if (iBehaviour.getStatus().equals(NodeStatus.Success)) {
                ++successCount;
                if (successPolocy.equals(Policy.RequireOne)) {
                    iBehaviour.reset();
                    return NodeStatus.Success;
                }
            }

            if (iBehaviour.getStatus().equals(NodeStatus.Failure)) {
                ++failureCount;
                if (failPolocy.equals(Policy.RequireOne)) {
                    iBehaviour.reset();
                    return NodeStatus.Failure;
                }
            }
        }

        if (failPolocy.equals(Policy.RequireAll) && failureCount == childrenSize) {
            for (ITree iBehaviour : getChildren()) {
                iBehaviour.reset();
            }
            return NodeStatus.Failure;
        }
        if (successPolocy.equals(Policy.RequireAll) && successCount == childrenSize) {
            for (ITree iBehaviour : getChildren()) {
                iBehaviour.reset();
            }
            return NodeStatus.Success;
        }

        return NodeStatus.Running;
    }

    @Override
    public void terminate(NodeStatus Status) {
        for (ITree iBehaviour : getChildren()) {
            if (iBehaviour.getStatus().equals(NodeStatus.Running)) {
                iBehaviour.abort();
            }

            iBehaviour.reset();
        }
    }
}
