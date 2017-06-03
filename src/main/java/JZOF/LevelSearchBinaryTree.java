package JZOF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yang on 2017/4/6.
 */
/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class LevelSearchBinaryTree {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(root==null){
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temNode = queue.poll();
            arrayList.add(temNode.val);
            if(temNode.left!=null){
                queue.offer(temNode.left);
            }
            if(temNode.right!=null){
                queue.offer(temNode.right);
            }

        }
        return arrayList;
    }
}
