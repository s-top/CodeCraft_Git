package com.huawei.codecraft.utils;

import com.huawei.codecraft.constant.Policy;
import com.huawei.codecraft.tree.impl.BTree;
import com.huawei.codecraft.tree.impl.BTreeBuilder;
import com.huawei.codecraft.tree.impl.composite.ParallelImpl;
import com.huawei.codecraft.tree.impl.composite.SelectorImpl;
import com.huawei.codecraft.tree.impl.composite.SequenceImpl;
import com.huawei.codecraft.tree.impl.decorator.Repeat;

public class TreeUtil {

    //测试行为树
    public static void testBT() {
//        BTreeBuilder builder = new BTreeBuilder();
//        BTree behaviorTree =
//                builder.addBehaviour(new SelectorImpl())
//                        .addBehaviour(new SequenceImpl())
//                        .addBehaviour(new ConditionIsSeeEnemy())
//                        .back()
//                        .addBehaviour(new SelectorImpl())
//                        .addBehaviour(new SequenceImpl())
//                        .addBehaviour(new ConditionIsHealthLow())
//                        .back()
//                        .addBehaviour(new ActionRunaway())
//                        .back()
//                        .back()
//
//                        .addBehaviour(new ParallelImpl(Policy.RequireAll, Policy.RequireOne))
//                        .addBehaviour(new ConditionIsEnemyDead(true))
//                        .back()
//                        .addBehaviour(new Repeat())
//                        .addBehaviour(new ActionAttack())
//                        .back()
//                        .back()
//                        .back()
//                        .back()
//                        .back()
//                        .addBehaviour(new ActionPatrol())
//                        .end();
//
//        //模拟执行行为树
//        for (int i = 0; i < 10; ++i) {
//            behaviorTree.process();
//            System.out.println("--------------" + i + "------------");
//        }
//        System.out.println("pause ");
    }
}
