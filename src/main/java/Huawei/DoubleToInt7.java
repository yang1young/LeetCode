package Huawei;

import java.util.Scanner;

/**
 * Created by yangqiao on 28/7/17.
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 输入描述:

 输入一个正浮点数值

 输出描述:

 输出该数值的近似整数值
 */
public class DoubleToInt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double num = sc.nextDouble();
            if(num-0>0.000001){
                int floor = (int)Math.round(num);
                System.out.println(floor);
            }
        }
    }
}
