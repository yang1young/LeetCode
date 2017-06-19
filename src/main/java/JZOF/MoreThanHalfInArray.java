package JZOF;

/**
 * Created by yangqiao on 19/6/17.
 */
/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
如果不存在则输出0。
 */
public class MoreThanHalfInArray {

    /*
    受快速排序的partition函数的启发，我们可以利用反复调用partition函数来求的该数字。
    我们现在数组中随机选取一个数字，而后通过Partition函数返回该数字在数组中的索引index，
    如果index刚好等于n/2，则这个数字便是数组的中位数，也即是要求的数，如果index大于n/2，
    则中位数肯定在index的左边，在左边继续寻找即可，反之在右边寻找。这样可以只在index的一边寻找，
    而不用两边都排序，减少了一半排序时间。这种情况的平均时间复杂度大致为：T(n) = n+n/2+n/4+n/8+....+1，
    很明显当n很大时，T(n)趋近于2n，也就是说平均情况下时间复杂度为O(n),但是这种情况下，
    最坏的时间复杂度依然为O(n*n)，最坏情况下，index总是位于数组的最左或最右边，
    这样时间复杂度为T(n) = n+n-1+n-2+n-3+....+1 = n(n-1)/2，显然，
    时间复杂度为O(n*n)，空间复杂度为O(1)。
     */
    private static int getPivot(int[] array, int start, int end) {
        int i = start - 1;
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
        array[end] = array[i + 1];
        array[i + 1] = temp;
        return i + 1;
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int result = 0;
        if (array != null) {
            int index = 0;
            int beg = 0;
            int end = array.length;
            int mid = end / 2;
            while (index != mid) {
                if (index > mid) {
                    end = mid;
                    index = getPivot(array, beg, end - 1);
                } else if (index < mid) {
                    beg = mid;
                    index = getPivot(array, beg, end - 1);
                }
            }
            int count = 0;
            for (int v : array) {
                if (v == array[mid]) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                result = array[mid];
            }
        }
        return result;
    }


    /*
    由于该数字的出现次数比所有其他数字出现次数的和还要多，因此可以考虑在遍历数组时保存两个值：
    一个是数组中的一个数字，一个是次数，。当遍历到下一个数字时，如果下一个数字与之前保存的数字相同，
    则次数加1，如果不同，则次数减1，如果次数为0，则需要保存下一个数字，并把次数设定为1。
    由于我们要找的数字出现的次数比其他所有数字的出现次数之和还要大，则要找的数字肯定是组后一次把
    次数设为1时对应的数字。该方法的时间复杂度为O(n)，空间复杂度为O(1)。
     */
    public static int MoreThanHalfNum_Solution_2(int[] array) {
        int temp = 0;
        int tempCount = 0;
        for (int v : array) {
            if (tempCount == 0) {
                temp = v;
                tempCount = 1;
            } else {
                if (temp == v) {
                    tempCount++;
                } else {
                    tempCount--;
                }
            }

        }
        int count = 0;
        for (int v : array) {
            if (v == temp) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return temp;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(MoreThanHalfInArray.MoreThanHalfNum_Solution_2(array));
    }


}

/*
change problem to is half of an Array, solution is:
 */
class IsHalfOfArray {
    static int Find(int[] a, int N)  //a代表数组，N代表数组长度
    {
        int candidate = 0;
        int nTimes, i;
        for (i = nTimes = 0; i < N; i++) {
            if (nTimes == 0) {
                candidate = a[i];
                nTimes = 1;
            } else {
                if (candidate == a[i])
                    nTimes++;
                else
                    nTimes--;
            }
        }

        int cTimes = 0;
        int candidate2 = a[N - 1];
        for (i = 0; i < N; i++) {
            if (a[i] == candidate) {
                cTimes++;
            }
        }

        return cTimes == N / 2 ? candidate : candidate2;
    }
}