import astextractor.ASTExtractor;
import astparser.JavaASTParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;


/**
 * Created by qiaoyang on 17-5-6.
 */
public class Test {

    public static String getString(TreeMap<Integer,String> result){
        String finalString= "";
        Iterator titer=result.entrySet().iterator();
        while(titer.hasNext()){
            Map.Entry ent=(Map.Entry )titer.next();
            int keyt=Integer.parseInt(ent.getKey().toString());
            String valuet=ent.getValue().toString();
            if(keyt!=0&&keyt!=6){
                finalString +=valuet+" , ";
            }
        }
        finalString = finalString.substring(0,finalString.length()-3);
        return finalString;
    }


    public static void main(String[] args) throws Exception{

        //String path = "/home/qiaoyang/codeData/demo.java";//"/home/qiaoyang/javaProject/JavaAnalyse/src/main/resources/a.java"
        BufferedWriter bw=null;
        try {
            bw=new BufferedWriter(new FileWriter("/home/qiaoyang/codeData/malware/typeData.csv"));
            final LineIterator it = FileUtils.lineIterator(new File("/home/qiaoyang/codeData/malware/originData.csv"), "UTF-8");
            while (it.hasNext()) {
                final String line = it.nextLine();
                String code = "class A{ "+line.split("@")[0]+" }";
                String tag = line.split("@")[1];
                System.out.println(tag);
                ASTExtractor.parseString(code);
                TreeMap<Integer,String> result = JavaASTParser.map;
                String ast = getString(result);

                bw.write(ast+" @"+tag);
                bw.newLine();
                result.clear();
            }
            it.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.flush();
                //使用BufferedWriter一定要在关闭前刷新
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }





    }
}
