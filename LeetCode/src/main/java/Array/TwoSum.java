package Array;

/**
 * Created by qiaoyang on 16-4-17.
 */
/*
原则：
1. 一道题只有一个public类，public类用来记录LeetCode上给的标准方法名，免得再复制粘贴一次
2.每个人的解题思路使用包可见类实现，命名规则为public类+数字0，1，2，3
  约定我是0，魏楚阳为1，张玲瑶为2，黄坤鸿为3
3.测试使用Junit框架，保存测试用例，测试命名方式和解题类一致，方便大家看思路和帮你Fix Bug
4.多写注释和心得体会，解题思路和遇到的问题，以便全方位覆盖知识点，有问题写在注释里，别人看到直接解答
 */
/*
Given an array of integers, return indices of the two numbers such that they add up
to a specific target.You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return null;
    }
}


/*
    暴力搜索，时间复杂度O（n^2）
    答案 Two-pass Hash Table ,O(n)
     */
class TwoSum0 extends TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[]{i, j};
                    return result;
                }
            }
        }
        return null;
    }
}


