package Huawei;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by yang on 2017/3/24.
 */
/*
输入一个字符串，求出该字符串包含的字符集合
输入描述:
每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。

输出描述:
每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。

输入例子:
abcqweracb

输出例子:
abcqwer
 */
public class UnDuplicateChars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            HashSet<Character> charSet = new HashSet<Character>();
            StringBuffer result = new StringBuffer();
            for(int i = 0 ;i<input.length();i++){
                char tempChar = input.charAt(i);
                if(!charSet.contains(tempChar)){
                    charSet.add(tempChar);
                    result.append(tempChar);
                }
            }
            System.out.println(result.toString());

        }
    }
}
