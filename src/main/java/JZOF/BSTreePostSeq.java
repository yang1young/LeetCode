package JZOF;

/**
 * Created by yang on 2017/4/7.
 */
/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class BSTreePostSeq {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    private boolean VerifySquenceOfBST(int [] sequence,int start,int end){
        int i,j;
        int root = sequence[end];
        for(i=start;sequence[i]<root&&i<end;i++);
        for(j=i;j<end;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left=true,right=true;
        if(i-start>0){
            left = VerifySquenceOfBST(sequence,start,i-1);
        }
        if(j-i>0){
            right = VerifySquenceOfBST(sequence,i,j-1);
        }
        return left&right;
    }

    public static void main(String[] args) {
        int[] seq = new int[]{7,4,6,5};
        System.out.println(new BSTreePostSeq().VerifySquenceOfBST(seq));
    }


}
