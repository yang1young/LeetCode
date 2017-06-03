import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Qiao Yang on 30/12/2016.
 */
public class RegexUtils {

    public static String codeClean(String input) {
        String pattern = "<code>[^>]+</code>";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        String result = null;
        boolean firstResult = true;

        while (m.find()) {
            if (firstResult) {
                result = m.group();
                firstResult = false;
            } else {
                if (m.group().length() > result.length()) {
                    result = m.group();
                }
            }
        }
        if (result != null && getCodeLongEnough(result)) {
            result = result.replaceAll("&#xA", "\n");
            result = result.replaceAll(";", "");
            //result = result.replaceAll(",", "");
            result = result.replaceAll("'", "");
            result = result.replaceAll("<[^>]+>", "");
            result = result.replaceAll("&lt", "<");
            result = result.replaceAll("&gt", ">");
            result = result.replaceAll("&amp", "&");
            result = result.replaceAll(" +", " ");
            result = result.replaceAll("[\\r\\n]+", "\n");
            return result;
        }
        return null;

    }


    public static boolean getCodeLongEnough(String txt) {
        Pattern p = Pattern.compile("&#xA", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        int count = 0;
        while (m.find()) {
            count++;
            if (count > 4) {
                return true;
            }
        }
        return false;
    }


    public static String tagsClean(String tags) {
        String result = tags.replaceAll("><", "#");
        result = result.replaceAll("<", "");
        result = result.replaceAll(">", "");
        return result;
    }


    public static void main(String args[]) {
        String t = "<c++><oop><encapsulation><friend>";
        System.out.println(tagsClean(t));

        String s = "<p>I want to use a track-bar to change a form's opacity.</p>&#xA;&#xA;<p>This is my code:</p>&#xA;&#xA;<pre><code>decimal trans = trackBar1.Value / 5000;&#xA;this.Opacity = trans;&#xA;</code></pre>&#xA;&#xA;<p>When I try to build it, I get this error:</p>&#xA;&#xA;<blockquote>&#xA;  <p>Cannot implicitly convert type 'decimal' to 'double'.</p>&#xA;</blockquote>&#xA;&#xA;<p>I tried making <code>trans</code> a <code>double</code>, but then the control doesn't work. This code has worked fine for me in VB.NET in the past. </p>&#xA";
        System.out.println(getCodeLongEnough(s));

    }
}
