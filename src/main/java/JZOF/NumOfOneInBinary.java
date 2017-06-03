package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumOfOneInBinary {
    public int NumberOf1(int n) {
        int count = 0;
        if(n<0){
            n = n&0x7FFFFFFF;
            count++;
        }
        while(n!=0){
            count += n&1;
            n = n>>1;
        }

        return count;
    }
}
