package JZOF;

/**
 * Created by yang on 2017/3/15.
 */

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode result = cons(pre,in,0,pre.length-1,0,in.length-1);
        return result;
    }

    public TreeNode cons(int[] pre, int[] in,int startPre,int endPre,int startIn, int endIn){

        TreeNode root = new TreeNode(pre[startPre]);
        root.left = root.right = null;
        int middle = 0;
        for(int i = 0;i<in.length;i++){
            if(in[i]==pre[startPre]){
                middle = i;
                break;
            }
        }
        if(middle-startIn>0) {
            root.left = cons(pre,in,startPre+1,startPre+middle-startIn,startIn,middle-1);
        }
        if(endIn-middle>0){
            root.right = cons(pre,in,startPre+middle-startIn+1,endPre,middle+1,endIn);
        }
       return root;
    }

    public void PreOrder(TreeNode root)//先序递归遍历
    {
        if(root!=null){
            System.out.print(root.val+"--");//访问仅作输出操作
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

}




class ReConstructBinaryTree1 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode result = reCon(pre,in);
        return result;
    }
    private TreeNode reCon(int[] pre, int[] in){
        TreeNode result;
        int root = pre[0];
        int middle = 0;
        for(int i = 0;i<in.length;i++){
            if(in[i]==root){
                middle = i;
                break;
            }
        }
        result = new TreeNode(pre[0]);
        result.left = result.right = null;


        int[] newInLeft = getSubArray(in,0,middle);
        if(newInLeft.length>0) {
            int[] newPreLeft = getSubArray(pre, 1, 1 + newInLeft.length);
            result.left = reCon(newPreLeft,newInLeft);
        }

        int[] newInRight = getSubArray(in,middle+1,in.length);
        if(newInRight.length>0) {
            int[] newPreRight = getSubArray(pre, 1 + newInLeft.length, pre.length);
            result.right = reCon(newPreRight,newInRight);
        }
        return result;
    }


    public int[] getSubArray(int[] array,int start,int end){
        int[] result = new int[end-start];
        for(int i = 0;i<end-start;i++){
            result[i] = array[start+i];
        }
        return result;
    }

    public void PreOrder(TreeNode root)//先序递归遍历
    {
        if(root!=null){
            System.out.print(root.val+"--");//访问仅作输出操作
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        ReConstructBinaryTree i = new ReConstructBinaryTree();
        TreeNode node = i.reConstructBinaryTree(pre,in);
        i.PreOrder(node);
    }
}


/*
public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }

        return root;
    }
 */