import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by roygao on 15/10/21.
 */
public class Utils {


    public static void persistModel(Models model, String ModelPath) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ModelPath));
            oos.writeObject(model);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Models reloadPersistModel(String ModelPath) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(ModelPath)));
            Models model = (Models) ois.readObject();
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void libsvmToCsv(String inputFile, String outputFile, int numOfAttributes, ArrayList indexOfNominal) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String s;
        Pattern patternIsNum = Pattern.compile("[0-9.]*");
        Pattern patternIsSciNotation = Pattern.compile("^((\\d+.?\\d+)[E]{1}(\\d+))$");
        long lineNum = 0;

        try {
            br = new BufferedReader(new FileReader(inputFile));
            bw = new BufferedWriter(new FileWriter(outputFile));
            int errorCount = 0;
            do {
                s = br.readLine();
                lineNum++;
                boolean errorFlag = false;
                if (s == null)
                    break;
                String[] result = new String[numOfAttributes + 1];
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < numOfAttributes; i++) {
                    result[i] = "0,";
                }

                String temp[] = s.split(" ");
                result[numOfAttributes] = temp[0];
                for (int i = 1; i < temp.length; i++) {
                    String[] innerTemp = temp[i].split(":");
                    char[] indexArray = innerTemp[0].toCharArray();
                    if (innerTemp.length > 1) {
                        int attributesIndex = Integer.parseInt(innerTemp[0]);
                        Matcher isSciNotation = patternIsSciNotation.matcher(innerTemp[1]);
                        Matcher isNum = patternIsNum.matcher(innerTemp[1]);

                        if (isSciNotation.matches()) {
                            result[attributesIndex - 1] = new BigDecimal(innerTemp[1]).toPlainString() + ",";
                        } else if (isNum.matches() || indexOfNominal.contains(attributesIndex)) {
                            result[attributesIndex - 1] = innerTemp[1] + ",";
                        } else {
                            errorFlag = true;
                        }
                    }
                }
                if (errorFlag) {
                    errorCount++;
                    System.out.println("第" + errorCount + "条-----第 " + lineNum + "行------ " + s);
                }
                for (int j = 0; j < numOfAttributes + 1; j++) {
                    sb.append(result[j]);
                }
                bw.write(sb.toString());
                bw.newLine();
            } while (s != null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
