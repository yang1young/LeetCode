package leetcode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by yang on 2017/3/7.
 */
public class AlibabaHeartCurve{

    public static final int epoch = 1000;

    static double leartCurve(double mu1, double sigma1, double mu2, double sigma2) {
        //N(a,b)的数：Math.sqrt(b)*random.nextGaussian()+a
        if(Math.abs(sigma1)<0.0000001||Math.abs(sigma1)<0.0000001){
            return 0.0;
        }
        Random randomno = new Random();
        double[] x = new double[epoch];
        double[] y = new double[epoch];
        for (int i = 0; i < epoch; i++) {
            x[i] = mu1 + sigma1 * randomno.nextGaussian();
            y[i] = mu2 + sigma2 * randomno.nextGaussian();
        }
        int count = 0;
        for (int i = 0; i < epoch; i++) {
            double X = x[i];
            double Y = y[i];
            double value = Math.pow((X * X + Y * Y) - 1, 3) - Math.pow(X * Y, 2) * Y;
            if (value > 0.0) {
                count++;
            }
        }
        DecimalFormat df = new DecimalFormat("######0.0");
        double result = Double.parseDouble(df.format((double) count / (double) epoch));
        return result;
    }


    public static void main(String[] args) {
        double res;
        double _mu1 = 3;
        double _sigma1 = 1;
        double _mu2 = 0;
        double _sigma2 = 1;

        res = leartCurve(_mu1, _sigma1, _mu2, _sigma2);
        System.out.println(String.valueOf(res));
    }

}
