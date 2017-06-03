package me.tomassetti.examples;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import me.tomassetti.support.DirExplorer;

import java.io.File;
import java.io.IOException;
//java -cp /home/qiaoyang/.gradle/caches/modules-2/files-2.1/com.github.javaparser/javaparser-core/2.3.0/a0ff6b83141734b4f7df2c1a7b0fa2ad5dc67523/javaparser-core-2.3.0.jar:./ me.tomassetti.examples.ListClassesExample
public class ListClassesExample {

    public static void listClasses(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" * " + n.getName());
                    }
                }.visit(JavaParser.parse(file), null);
                System.out.println("uuu"); // empty line
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }).explore(projectDir);
    }

    public static void main(String[] args) {
        System.out.println("test");
        File projectDir = new File("source_to_parse/junit-master");
        listClasses(projectDir);
    }
}
