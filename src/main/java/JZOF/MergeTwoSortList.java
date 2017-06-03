package JZOF;

/**
 * Created by yang on 2017/3/24.
 */
/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoSortList {

    public ListNode MergeRecur(ListNode list1, ListNode list2) {
        ListNode head;
        if (list1 == null || list2 == null) {
            head = list1 == null ? list2 : list1;
            return head;
        }
        if(list1.val<list2.val){
            head = list1;
            head.next = MergeRecur(list1.next,list2);
        }
        else{
            head = list2;
            head.next = MergeRecur(list1,list2.next);
        }
        return head;
    }


    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = null;
        if (list1 == null || list2 == null) {
            head = list1 == null ? list2 : list1;
            return head;
        }
        ListNode temp = null;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        if (temp1.val < temp2.val) {
            head = temp1;
            temp1 = temp1.next;
        } else {
            head = temp2;
            temp2 = temp2.next;
        }
        temp = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode temp1 = new ListNode(1);
        temp1.next = new ListNode(2);
        temp1.next.next = new ListNode(4);

        ListNode temp2 = new ListNode(3);
        temp2.next = new ListNode(6);
        ListNode result = new MergeTwoSortList().MergeRecur(temp1, temp2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
