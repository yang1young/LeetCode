package leetcode;
/**
 * Created by yang on 2017/1/18.
 */

/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Subscribe to see which companies asked this question

//      123321
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x/10==0){
            return true;
        }
        int l = 1;
        int maxDiv = 1;
        int origin = x;
        while(origin/10!=0){
            l++;
            maxDiv *= 10;
            origin = origin/10;
        }
        //123321
        //12321
        while(x/10>=0){
            if(x/maxDiv != x%10){
                return false;
            }
            x = (x%maxDiv)/10;
            maxDiv /=100;
            if(maxDiv/10 ==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        PalindromeNumber p = new PalindromeNumber();
        System.out.println( p.isPalindrome(1001));

    }

}
