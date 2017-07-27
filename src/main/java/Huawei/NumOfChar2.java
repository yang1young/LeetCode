package Huawei;

import java.io.BufferedInputStream;
import java.util.*;
/**
 * Created by yangqiao on 27/7/17.
 * 题目描述

 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 输入描述:

 输入一个有字母和数字以及空格组成的字符串，和一个字符。

 输出描述:

 输出输入字符串中含有该字符的个数。

 示例1
 输入

 ABCDEF
 A

 输出

 1

 */
public class NumOfChar2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String i = scanner.nextLine();
            int count = 0;
            if(s!=null && i!=null&& i.length()==1){
                char[] array = s.toLowerCase().toCharArray();
                char find = i.charAt(0);
                for(int j =0;j<array.length;j++){
                    if(array[j]==find){
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }
}
