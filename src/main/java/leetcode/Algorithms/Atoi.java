package leetcode;

/**
 * Created by yang on 2017/1/16.
 */
/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
If you want a challenge, please do not see below
and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified
vaguely (ie, no given input specs). You are responsible
to gather all the input requirements up front.
 */
public class Atoi {
    public int myAtoi(String str) {

        if(str==null){
            return 0;
        }
        int result = 0;
        char[] arr = str.toCharArray();
        int flag = 1;
        boolean isStart = true;

        for(int i = 0; i<arr.length; i++) {
            if (arr[i] > 47 && arr[i] < 58) {

                if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && arr[i]-'0'>7) {
                    return flag==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                result = result * 10 + (arr[i] - '0');
                isStart = false;
            }
            else{
                if (isStart&&arr[i] == '-') {
                    flag = -1;
                    isStart = false;
                }
                else if (isStart&&arr[i] == '+'){
                    isStart = false;
                }
                else if(isStart&&arr[i]==' ') {
                    continue;
                }
                else {
                    break;
                }
            }
        }


        return flag*result;
    }

    public static void main(String[] args){
        String a= "-2147483648";
        Atoi x= new Atoi();
        System.out.println(x.myAtoi(a));
    }
}


