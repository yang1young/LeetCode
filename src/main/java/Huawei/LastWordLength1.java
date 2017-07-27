package Huawei;

import java.util.*;
import java.io.*;

/*
题目描述

计算字符串最后一个单词的长度，单词以空格隔开。
输入描述:

一行字符串，非空，长度小于5000。

输出描述:

整数N，最后一个单词的长度。

示例1
输入

hello world

输出

5
        Scanner cin2 = new Scanner(new BufferedInputStream(System.in));

 */
public class LastWordLength1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input = cin.nextLine();
            int N = 0;
            if (input != null) {
                String[] strings = input.split(" ");
                N = strings[strings.length - 1].length();
            }
            System.out.println(N);
        }
    }
}
