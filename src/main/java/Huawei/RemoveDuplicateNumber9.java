package Huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yangqiao on 28/7/17.
 * 题目描述

 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 输入描述:

 输入一个int型整数

 输出描述:

 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

 示例1
 输入

 9876673

 输出

 37689
 */
public class RemoveDuplicateNumber9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] index = new int[10];
            for(int i = 0;i<10;i++){
                index[i] = 0;
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            char[] nums = sc.nextLine().toCharArray();
            for(int i = nums.length-1;i>=0;i--){
                int temp = nums[i]-'0';
                if(index[temp]==0){
                    index[temp]=1;
                    list.add(temp);
                }
            }
            int result = 0;
            for(int i =0;i<list.size();i++){
                result = result*10+list.get(i);
            }
            System.out.println(result);
        }
    }
}
