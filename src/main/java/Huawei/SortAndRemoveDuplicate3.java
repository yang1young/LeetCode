package Huawei;

import javafx.beans.binding.IntegerBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by yangqiao on 27/7/17.
 *  明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。

 Input Param

 n               输入随机数的个数

 inputArray      n个随机整数组成的数组

 Return Value

 OutputArray    输出处理后的随机整数


 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。

 输入描述:

 输入多行，先输入随机整数的个数，再输入相应个数的整数

 输出描述:

 返回多行，处理后的结果
 */

public class SortAndRemoveDuplicate3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] set = new int[1000];
            for (int i = 0; i < 1000; i++) {
                set[i] = 0;
            }

            ArrayList list = new ArrayList();
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (set[temp] == 0) {
                    set[temp] = 1;
                    list.add(temp);
                }
            }
            //Collections.sort(list);
            int[] newlist = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                newlist[i] = Integer.parseInt(list.get(i).toString());
            }
            qsort(newlist, 0, newlist.length - 1);

            for (int i = 0; i < newlist.length; i++) {
                System.out.println(newlist[i]);
            }
        }
    }


    private static int getPivot(int[] array, int start, int end) {
        int r = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < r) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = temp;
        return i + 1;
    }

    private static void qsort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = getPivot(array, start, end);
            qsort(array, 0, pivot - 1);
            qsort(array, pivot + 1, end);
        }
    }
}
