package com.huawei.codecraft.tree.impl.composite;

import com.huawei.codecraft.constant.NodeStatus;
import com.huawei.codecraft.tree.ITree;
import com.huawei.codecraft.tree.base.BaseComposite;
import com.huawei.codecraft.tree.composite.ISequence;

import java.util.Iterator;

public class SelectorImpl extends BaseComposite implements ISequence {

  private ITree currChild;

  @Override
  public NodeStatus update() {
    Iterator<ITree> iterator = getChildren().iterator();
    if (iterator.hasNext()) {
      while (true) {
        currChild = iterator.next();
        NodeStatus s = currChild.process();
        if (s != NodeStatus.Failure)
          return s;
        if (!iterator.hasNext())
          return NodeStatus.Failure;
      }
    }
    return NodeStatus.Init;
  }
}
