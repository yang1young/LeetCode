package Huawei;

import java.util.Scanner;

/**
 * Created by yangqiao on 28/7/17.
 *  写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 输入描述:

 输入一个十六进制的数值字符串。

 输出描述:

 输出该数值的十进制字符串。


 */
public class BaseOfString5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int num = Integer.parseInt(s.replace("0x",""),16);
            System.out.println(num);
        }
    }
}
