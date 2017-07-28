/**
 * Created by yang on 2017/1/5.
 */
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

public class LongestPalindromicSubstring_5 {

    //babadcdsdfsfs
    public String longestPalindrome(String s) {
        String result = null;
        if(s==null){
            return null;
        }
        if(s.length()==1){
            return s;
        }
        //char[] ss = s.toCharArray();
        for(int i = 1;i<s.length();i++){



            if(s.charAt(i)==s.charAt(i-1)){

            }


        }




        return result;
    }

}
