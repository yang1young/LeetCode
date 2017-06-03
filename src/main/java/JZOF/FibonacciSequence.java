package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */
public class FibonacciSequence {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int fn1 = 0;
        int fn2 = 1;
        int fn = 0;
        for (int i = 2; i < n; i++) {
            fn = fn1+fn2;
            fn1 = fn2;
            fn2 = fn;
        }
        return fn;
    }

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }

        int fn1 = 1;
        int fn2 = 2;
        int fn = 0;
        for (int i = 3; i < target; i++) {
            fn = fn1+fn2;
            fn1 = fn2;
            fn2 = fn;
        }
        return fn;
    }

}
