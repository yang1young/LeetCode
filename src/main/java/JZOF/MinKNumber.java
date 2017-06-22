package JZOF;

import java.util.ArrayList;

/**
 * Created by yangqiao on 21/6/17.
 */
/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，
则最小的4个数字是1,2,3,4,。
 */
public class MinKNumber {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(k < 0 || k > array.length){
            return;
        }
        int[] temp = new int[k];

        for(int i = 0; i < k; i++){
            temp[i] = array[i];
        }
        for(int i = k; i < array.length; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < temp.length; j++){
                if(temp[j] < min){
                    min = temp[j];
                    minIndex = j;
                }
            }
            if(array[i] > min){
                temp[minIndex] = array[i];
            }
        }
        for(int i : temp){
            System.out.print(i + " ");
        }
        return result;
    }
}
