package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
/*
一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class PivotArrayMiniNumber {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        int middle = start;
        if(start==end){
            return array[0];
        }

        while (end-start>1){
            middle = (start+end)/2;
            if(array[middle]>array[end]){
                start = middle;
            }
            else {
                end = middle;
            }
        }
        return array[start]>array[end]? array[end]:array[start];
    }

    public static void main(String[] args) {

    }
}
