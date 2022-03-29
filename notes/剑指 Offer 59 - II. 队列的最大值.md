# 剑指 Offer 59 - II. 队列的最大值

```text
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
```

**示例1：**

```text
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
```

**示例2：**

```text
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
```

```java

import java.util.LinkedList;

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    //初始化方法
    public MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    //弹出一个最大值
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    //入队
    public void push_back(int value) {
        //将元素入队
        queue.offer(value);
        //将双向队列中队尾 所有 小于 value 的元素弹出（以保持 deque 非单调递减），并将元素 value 入队 deque ；
        //这里处理起来比栈的要高级一点
        //双端队列可以在队头队尾操作，因为会有 first 和 last
        while (!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }

    //出队
    public int pop_front() {
        //队列为空
        if (queue.isEmpty()) return -1;
        //判断出队的元素是不是队列的最大值，是的话也要出 deque 保持两个队列的一致性
        if (queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        //queue 出队
        return queue.poll();
    }
}
```