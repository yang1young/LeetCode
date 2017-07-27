package Huawei;

import java.util.Scanner;

/**
 * Created by yangqiao on 27/7/17.
 * <p>
 * <p>
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * <p>
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * <p>
 * 输出到长度为8的新字符串数组
 * <p>
 * 示例1
 * 输入
 * <p>
 * abc
 * 123456789
 * <p>
 * 输出
 * <p>
 * abc00000
 * 12345678
 * 90000000
 */
public class StringSplit {

    public static void printArray(String s) {
        char[] array = s.toCharArray();
        int pad = array.length % 8 == 0 ? 0 : (8 - array.length % 8);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != 0 && (i + 1) % 8 == 0) {
                System.out.println();
            }
        }
        for (int j = 0; j < pad; j++) {
            System.out.print('0');
        }
        if (pad != 0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if (s1 != null) {
                printArray(s1);
            }
            if (s2 != null) {
                printArray(s2);
            }
        }
    }
}
