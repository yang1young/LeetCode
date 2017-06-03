package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class DoubleExp {

    public double Power(double base, int exponent) {
        if(base==0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }

        double result = 1;
        int exp = exponent>0?exponent:-exponent;
        for(int i = 0;i<exp;i++){
            result *= base;
        }
        if(exponent<0){
            result  = 1/result;
        }
        return result;
    }

    public double PowerRecur(double base, int exponent) {
        if(base<0.00000001&&base>-0.00000001){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
        double result = 1;
        int exp = exponent>0?exponent:-exponent;
        result = PowerIn(base,exp);

        if(exponent<0){
            result  = 1/result;
        }
        return result;
    }

    private double PowerIn(double base, int exponent){

        if(exponent ==0){
            return 1;
        }
        int isOdd = exponent&1;
        double mul = isOdd==1?base:1;
        double result = PowerIn(base,exponent>>1);
        result = mul*result*result;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DoubleExp().PowerRecur(2,7));
    }


}
