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
        int[] numbers = new int[]{1, 4, 2, 8, 15, 7, 9, 10};
        ArrayList<Integer> result = new MinKNumber().GetLeastNumbers_Solution(numbers, 5);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /*
    using quiksort partition function
     */
    private int partition(int[] input, int start, int end) {
        int pivot = input[end];
        int i = start - 1;
        for (int j = i + 1; j < end; j++) {
            if (input[j] < pivot) {
                i++;
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
            }
        }
        int temp = input[end];
        input[end] = input[i + 1];
        input[i + 1] = temp;
        return i + 1;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input != null && k != 0 && k <= input.length) {
            int pivot = partition(input, 0, input.length - 1);
            while (pivot != k - 1) {
                if (pivot > k - 1) {
                    pivot = partition(input, 0, pivot - 1);
                } else if (pivot < k - 1) {
                    pivot = partition(input, pivot + 1, input.length - 1);
                }
            }
            int index = 0;
            while (index < k) {
                result.add(input[index]);
                index++;
            }
        }
        return result;
    }


}


class MinKHeap{

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 4, 2, 8, 15, 7, 9, 10};
        ArrayList<Integer> result = new MinKNumber().GetLeastNumbers_Solution(numbers, 5);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input != null && k != 0 && k <= input.length) {

        }
        return result;
    }
}