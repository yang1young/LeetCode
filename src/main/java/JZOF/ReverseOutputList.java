package JZOF;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yang on 2017/3/15.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseOutputList {

    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            System.out.println(listNode.val);
            result.add(listNode.val);
        }
        return result;

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode,boolean isStack) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode tempNode = listNode;
        while(tempNode!=null){
            stack.push(tempNode.val);
            tempNode = tempNode.next;
        }

        while(!stack.empty()){
            result.add(stack.pop());
        }

        return result;

    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        ReverseOutputList a = new ReverseOutputList();
        System.out.println(a.printListFromTailToHead(list,true));
    }
}