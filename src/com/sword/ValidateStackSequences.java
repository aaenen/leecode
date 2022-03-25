package com.sword;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class ValidateStackSequences {
    //考虑借用一个辅助栈 stack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。
    //入栈操作： 按照压栈序列的顺序执行。
    //出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //初始化： 辅助栈 stack ，弹出序列的索引 i ；
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        //遍历压栈序列： 各元素记为 num ；
        for (int num : pushed) {
            //元素 num 入栈；
            stack.push(num); // num 入栈
            ////循环出栈：若 stack 的栈顶元素 == 弹出序列元素 popped[i] ，则执行出栈与 i++ ；
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        //返回值： 若 stack 为空，则此弹出序列合法。
        return stack.isEmpty();
    }

    //方法二：这里有一个事实 那就是一组合法的入栈序列和出栈序列对应着一个二叉树的前序和中序 （应该是来源于2000多年浙大的一道考研真题） 即入栈序列对应一个二叉树的前序遍历
    //即出栈序列对应一个二叉树的中序遍历
}
