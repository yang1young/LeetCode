package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddAheadEven {
    public void reOrderArrayCantStaySeq(int[] array) {
        if (array == null) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while ((start < end) && (array[start] & 1) == 1) {
                start++;
            }
            while ((start < end) && (array[end] & 1) == 0) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        System.out.println('f');
    }


    public void reOrderArray(int[] array) {
        if (array == null) {
            return;
        }

        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                even[evenCount] = array[i];
                evenCount++;}
            else {
                odd[oddCount] = array[i];
                oddCount++;
            }
        }
        for (int i = 0; i < oddCount; i++) {
            array[i] = odd[i];
        }

        for (int i = 0; i < evenCount; i++) {
            array[i + oddCount] = even[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 2, 4, 5, 6, 8, 9};
        new OddAheadEven().reOrderArray(array);
    }

}
