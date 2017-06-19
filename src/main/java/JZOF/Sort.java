package JZOF;

/**
 * Created by yangqiao on 19/6/17.
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, 2, 3, 1, 9, 4};
        QuikSort.quikSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}


class QuikSort {

    /*
    private static int getPivot(int[] array, int start, int end) {
        int i = start;
        int key = array[start];
        for (int j = i + 1; j <= end; j++) {
            if (array[j] < key) {
                int temp = array[j];
                array[j] = array[i + 1];
                array[i + 1] = temp;
                i++;
            }
        }
        array[start] = array[i];
        array[i] = key;
        return i;
    }
*/

    private static int getPivot(int[] array, int start, int end) {
        int i = start-1;
        int key = array[end];
        for (int j = start; j < end; j++) {
            if (array[j] < key) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[end];
        array[end] = array[i+1];
        array[i+1] = temp;
        return i+1;
    }

    private static void qsort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = getPivot(array, start, end);
            qsort(array, 0, pivot - 1);
            qsort(array, pivot + 1, end);
        }
    }

    public static void quikSort(int[] array) {
        if (array != null) {
            qsort(array, 0, array.length - 1);
        }
    }
}