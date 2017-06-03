package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
/*
输入一个链表，输出该链表中倒数第k个结点。
 */

public class KNodeOfLinklist {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null||k==0) {
            return null;
        }
        ListNode kNode = head;
        for (int i = 0; i < k-1; i++) {
            kNode = kNode.next;
            if(kNode==null){
                return null;
            }
        }
        while (kNode!=null){
            kNode = kNode.next;
            head = head.next;
        }
        return head;
    }
}
