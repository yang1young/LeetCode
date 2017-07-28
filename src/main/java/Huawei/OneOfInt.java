package Huawei;

import java.util.Scanner;

/**
 * Created by yangqiao on 28/7/17.
 *
 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 输入描述:

 输入一个整数（int类型）

 输出描述:

 这个数转换成2进制后，输出1的个数
 */
public class OneOfInt {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            //String num = sc.nextLine();
            int num = sc.nextInt();
            String numString = Integer.toBinaryString(num);
            int count = 0;
            for(int i = 0;i<numString.length();i++){
                if(numString.charAt(i)=='1'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

/*
右移位的基本思路是，先将整数转换成正整数，再将该数与1进行与运算。若不将整数做取绝对值处理，
当输入的数是负数时，每向右移动一位，高位会自动补1，就会导致死循环。
int ChargeOnesCountInNum1(int iNum)
{
    int iCount=0;
    iNum = abs(iNum);//注意添加上了绝对值
    while(iNum){
        if (iNum & 1){
            ++iCount;
        }
        iNum = iNum >> 1;
    }

    return iCount;
}
 */