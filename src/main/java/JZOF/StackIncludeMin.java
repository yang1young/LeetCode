package JZOF;

import java.util.Stack;

/**
 * Created by yang on 2017/4/6.
 */
/*
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackIncludeMin {

    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.empty()){
            minStack.push(node);
        }
        else{
            int tempMin = minStack.peek();
            tempMin = tempMin>node? node:tempMin;
            minStack.push(tempMin);
        }
    }

    public void pop() {
        if(!dataStack.empty()) {
            dataStack.pop();
        }
        if(!minStack.empty()) {
            minStack.pop();
        }
    }

    public int top() {
        if(!dataStack.empty()) {
            return dataStack.peek();
        }
        else {
            return 0;
        }

    }

    public int min() {
        if(!minStack.empty()) {
            return minStack.peek();
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {

    }


}
