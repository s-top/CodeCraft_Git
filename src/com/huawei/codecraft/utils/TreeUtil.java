package com.huawei.codecraft.utils;

import com.huawei.codecraft.MainContent;
import com.huawei.codecraft.tree.impl.BTree;
import com.huawei.codecraft.tree.impl.BTreeBuilder;
import com.huawei.codecraft.tree.impl.action.*;
import com.huawei.codecraft.tree.impl.composite.SelectorImpl;
import com.huawei.codecraft.tree.impl.composite.SequenceImpl;
import com.huawei.codecraft.tree.impl.condition.*;

public class TreeUtil {

    public static void processTree(MainContent mainContent, StringBuilder builder) {
        for (int i = 0; i < 2; i++) {
            BTreeBuilder treeBuilder = new BTreeBuilder();
            BTree behaviorTree = treeBuilder
                .addBehaviour(new SelectorImpl())
                    .addBehaviour(new SelectorImpl())
                        // 到-卖
                        .addBehaviour(new SequenceImpl())
                            .addBehaviour(new ConditionBack(mainContent, i)).back()
                            .addBehaviour(new ConditionHasArrived(mainContent, i)).back()
                            .addBehaviour(new ActionSell(mainContent, builder, i)).back()
                        .back()
                        // 回
                        .addBehaviour(new SequenceImpl())
                            .addBehaviour(new ConditionOutOfMap(mainContent, i)).back()
                            .addBehaviour(new ActionBackToMap(mainContent, builder, i)).back()
                        .back()
                        .addBehaviour(new ActionBackToWork(mainContent, builder, i)).back()
                    .back()
                    .addBehaviour(new SelectorImpl())
                        // 到-买
                        .addBehaviour(new SequenceImpl())
                            .addBehaviour(new ConditionGo(mainContent, i)).back()
                            .addBehaviour(new ConditionHasArrived(mainContent, i)).back()
                            .addBehaviour(new ActionBuy(mainContent, builder, i)).back()
                        .back()
                        // 去
                        .addBehaviour(new SequenceImpl())
                            .addBehaviour(new ConditionOutOfMap(mainContent, i)).back()
                            .addBehaviour(new ActionBackToMap(mainContent, builder, i)).back()
                        .back()
                        .addBehaviour(new ActionGo(mainContent, builder, i)).back()
                    .back()
                .end();
            behaviorTree.process();
        }
        for (int i = 2; i < 4; i++) {
            BTreeBuilder treeBuilder = new BTreeBuilder();
            BTree behaviorTree = treeBuilder
                    .addBehaviour(new SelectorImpl())
                        .addBehaviour(new SelectorImpl())
                            // 到-卖
                            .addBehaviour(new SequenceImpl())
                                .addBehaviour(new ConditionBack(mainContent, i)).back()
                                .addBehaviour(new ConditionHasArrived(mainContent, i)).back()
                                .addBehaviour(new ActionSell(mainContent, builder, i)).back()
                            .back()
                            // 回
                            .addBehaviour(new SequenceImpl())
                                .addBehaviour(new ConditionOutOfMap(mainContent, i)).back()
                                .addBehaviour(new ActionBackToMap(mainContent, builder, i)).back()
                            .back()
                            .addBehaviour(new ActionBackToWorkT(mainContent, builder, i)).back()
                            .addBehaviour(new ActionBackToWork(mainContent, builder, i)).back()
                        .back()
                        .addBehaviour(new SelectorImpl())
                            // 到-买
                            .addBehaviour(new SequenceImpl())
                                .addBehaviour(new ConditionGo(mainContent, i)).back()
                                .addBehaviour(new ConditionHasArrived(mainContent, i)).back()
                                .addBehaviour(new ActionBuy(mainContent, builder, i)).back()
                            .back()
                            .addBehaviour(new SequenceImpl())
                                .addBehaviour(new ConditionOutOfMap(mainContent, i)).back()
                                .addBehaviour(new ActionBackToMap(mainContent, builder, i)).back()
                            .back()
                            // 去
                            .addBehaviour(new SequenceImpl())
                                .addBehaviour(new ConditionLevelTwoWorkReady(mainContent, i)).back()
                                .addBehaviour(new ActionGoLevelTwo(mainContent, builder, i)).back()
                            .back()
                            .addBehaviour(new ActionGoLevelOne(mainContent, builder, i)).back()
                        .back()
                    .end();
            behaviorTree.process();
        }
    }
}
