package com.sword;

import java.util.Stack;

/**
 * 包含Min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class MinStack {

    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    //stack1.peek() 返回栈顶元素，但不在堆栈中删除它。
    //stack2.pop() 返回栈顶元素，并在进程中删除它。
    public void push(int x) {
        A.add(x);
        //如果B的栈顶元素>=x，就把x添加到B，就可以保证B的栈顶一直都是栈里面元素最小的
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
