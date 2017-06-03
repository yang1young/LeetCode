package leetcode;

/**
 * Created by yang on 2017/1/3.
 */

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = null;
        ListNode tempNode = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int sum;
        int jinwei = 0;
        int remaind;

        while(temp1!=null||temp2!=null||jinwei!=0){
            sum = (temp1==null? 0:temp1.val) + (temp2==null? 0:temp2.val) +jinwei;
            jinwei = sum/10;
            remaind = sum%10;
            if(list==null){
                tempNode = list = new ListNode(remaind);
            }else{
                tempNode = tempNode.next = new ListNode(remaind);
            }
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
        }

        return list;

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(8);
        l2.next.next = null;

        ListNode my = AddTwoNumbers_2.addTwoNumbers(l1,l2);
        System.out.println(my.val+"->"+my.next.val+"->"+my.next.next.val);
    }
}