/**
 * Created by qiaoyang on 17-5-6.
 */
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.Statement;
import com.google.common.base.Strings;
import me.tomassetti.support.DirExplorer;
import me.tomassetti.support.NodeIterator;

import java.io.File;
import java.io.IOException;

public class a {
    public static void statementsByLine(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new NodeIterator(new NodeIterator.NodeHandler() {
                    @Override
                    public boolean handle(Node node) {
                        if (node instanceof Statement) {
                            System.out.println(" [Lines " + node.getBeginLine() + " - " + node.getEndLine() + " ] " + node);
                            return false;
                        } else {
                            return true;
                        }
                    }
                }).explore(JavaParser.parse(file));
                System.out.println(); // empty line
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }).explore(projectDir);
    }

    public static void main(String[] args) {
        File projectDir = new File("/home/qiaoyang/javaProject/JavaAnalyse/src/main/resources/");
        statementsByLine(projectDir);
    }
}