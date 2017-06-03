package JZOF;

/**
 * Created by yang on 2017/3/15.
 */
/*
请实现一个函数，将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class RelaceBlank {
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        int numOfBlank = 0;
        int originLength = str.length();
        for(int i =0;i<originLength;i++){
            if(str.charAt(i)==' '){
                numOfBlank++;
            }
        }
        int lenghth = str.length()+2*numOfBlank;

        for (int i = originLength;i<lenghth;i++){
            str.append('0');
        }

        for(int i=originLength,j=lenghth;i>0&&j>0;i--,j--){
            if(str.charAt(i-1)!=' ') {
                char temp = str.charAt(i-1);
                str.setCharAt(j-1,temp );

            }
            else{
                str.setCharAt(j-1,'0');
                j--;
                str.setCharAt(j-1,'2');
                j--;
                str.setCharAt(j-1,'%');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RelaceBlank a = new RelaceBlank();
        StringBuffer sb = new StringBuffer("I am a student");
        String b = a.replaceSpace(sb);
        System.out.println(b);
    }
}
