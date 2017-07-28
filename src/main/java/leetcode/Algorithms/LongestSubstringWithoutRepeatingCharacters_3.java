package leetcode;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yang on 2017/1/4.
 */

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static int lengthOfLongestSubstring(String s) {
        int oldPosition = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        if(chars.length==0){
            return 0;
        }
        map.put(chars[0],0);
        //tmmzuxt uuuuuu
        max = 1;
        for(int i = 1;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                oldPosition = Math.max(oldPosition,map.get(chars[i])+1);
            }
            map.put(chars[i],i);
            max = Math.max(max,i-oldPosition+1);


        }
        return max;


    }
    public static void main(String[] args){
        String s = "tmmzuxt";
        System.out.println(LongestSubstringWithoutRepeatingCharacters_3.lengthOfLongestSubstring(s));
    }

}
