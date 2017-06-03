package JZOF;

/**
 * Created by yang on 2017/3/22.
 */
public class ReverseLinkedlist {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = null;
        ListNode newHead = null;
        while (head != null) {
            newHead = head.next;
            head.next = temp;
            temp = head;
            head = newHead;
        }
        return temp;
    }
}
