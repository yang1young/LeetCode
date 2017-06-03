package JZOF;

import java.util.Stack;

/**
 * Created by yang on 2017/4/6.
 */
/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是
该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */
public class StackInOutSeq {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||pushA.length!=popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;
        int pushIndex = 0;
        while (popIndex<popA.length){
            while ((pushIndex<pushA.length)&&(pushA[pushIndex]!=popA[popIndex])){
                stack.push(pushA[pushIndex++]);
            }
            if(!stack.empty()&&popA[popIndex]!=stack.peek()&&pushIndex>=pushA.length){
                break;
            }
            stack.push(pushA[pushIndex++]);
            while (!stack.empty()&&popA[popIndex]==stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return pushIndex >= pushA.length && popIndex == popA.length;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }

}
