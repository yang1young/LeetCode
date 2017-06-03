package JZOF;

/**
 * Created by yang on 2017/3/15.
 */
public class ArraySearch1{

    public boolean Find(int target, int [][] array) {
        if(array.length==0)
            return false;
        int row = 0,col = 0;
        for (;row<array.length;row++){
            for(;col<array[row].length;col++){

            }
        }
        int i=0,j=col;
        while (i<row&&j>0){
            if(array[i][j-1]==target){
                return true;
            }
            else if(array[i][j-1]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ArraySearch1 a = new ArraySearch1();
        int[][] array = {{1,3,5,7,9},{2,4,6,8,10},{9,12,14,17,19}} ;
    boolean b = a.Find(13,array);
        System.out.println(b);
    }

}
