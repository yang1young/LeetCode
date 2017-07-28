package Huawei;

import java.awt.peer.SystemTrayPeer;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by yangqiao on 28/7/17.
 * 题目描述

 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 输入描述:

 先输入键值对的个数
 然后输入成对的index和value值，以空格隔开

 输出描述:

 输出合并后的键值对（多行）

 输入

 4
 0 1
 0 2
 1 2
 3 4

 输出

 0 3
 1 2
 3 4


 */
public class GroupBy8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
            for(int i = 0;i<count;i++){
                int k = sc.nextInt();
                int v= sc.nextInt();
                if(map.containsKey(k)){
                    map.put(k,map.get(k)+v);
                }
                else
                    map.put(k,v);
            }

            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer,Integer> entry = it.next();
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}

/*
java map iter

1.
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}

2.
for (Integer key : map.keySet()) {
    Integer value = map.get(key);
    System.out.println("Key = " + key + ", Value = " + value);
}
3.
Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry<Integer, Integer> entry = entries.next();
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}

 */