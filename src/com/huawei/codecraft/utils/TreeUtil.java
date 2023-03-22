package com.huawei.codecraft.utils;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.tree.impl.BTree;
import com.huawei.codecraft.tree.impl.BTreeBuilder;
import com.huawei.codecraft.tree.impl.action.ActionBack;
import com.huawei.codecraft.tree.impl.action.ActionBuy;
import com.huawei.codecraft.tree.impl.action.ActionGo;
import com.huawei.codecraft.tree.impl.action.ActionSell;
import com.huawei.codecraft.tree.impl.composite.SelectorImpl;
import com.huawei.codecraft.tree.impl.composite.SequenceImpl;
import com.huawei.codecraft.tree.impl.condition.ConditionHasArrived;

public class TreeUtil {

    public static void processTree(MainContent mainContent, StringBuilder builder) {
        BTreeBuilder treeBuilder = new BTreeBuilder();
        BTree behaviorTree = treeBuilder
            .addBehaviour(new SelectorImpl())
                // 到-卖
                .addBehaviour(new SequenceImpl())
                    .addBehaviour(new ConditionHasArrived(mainContent, 5)).back()
                    .addBehaviour(new ActionSell(mainContent, builder)).back()
                .back()
                // 回
                .addBehaviour(new ActionBack(mainContent, builder)).back()
            .back()
            .addBehaviour(new SelectorImpl())
                // 到-买
                .addBehaviour(new SequenceImpl())
                    .addBehaviour(new ConditionHasArrived(mainContent, 1)).back()
                    .addBehaviour(new ActionBuy(mainContent, builder)).back()
                .back()
                // 去
                .addBehaviour(new ActionGo(mainContent, builder)).back()
            .back()
        .end();
        behaviorTree.process();
    }
}
