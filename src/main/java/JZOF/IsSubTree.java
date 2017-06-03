package JZOF;

/**
 * Created by yang on 2017/3/24.
 */
/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class IsSubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean isSubTree = false;
        if(root1!=null&&root2!=null) {
            if (root1.val == root2.val) {
                isSubTree = HasSubTree_(root1, root2);
            }
            if (!isSubTree) {
                isSubTree = HasSubtree(root1.left, root2) ;
            }
            if(!isSubTree){
                isSubTree = HasSubtree(root1.right, root2);
            }
        }
        return isSubTree;
    }

    public boolean HasSubTree_(TreeNode root1, TreeNode root2) {

        if (root2 == null || root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right);

    }
}
