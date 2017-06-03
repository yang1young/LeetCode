//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package weka.classifiers;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;
import weka.classifiers.AbstractClassifier;
import weka.core.Option;
import weka.core.Randomizable;
import weka.core.Utils;

public abstract class RandomizableClassifiers extends AbstractClassifier implements Randomizable,Classifier {
    private static final long serialVersionUID = -8816375798262351903L;
    protected int m_Seed = 1;

    public RandomizableClassifiers() {
    }

    public Enumeration<Option> listOptions() {
        Vector newVector = new Vector(2);
        newVector.addElement(new Option("\tRandom number seed.\n\t(default 1)", "S", 1, "-S <num>"));
        newVector.addAll(Collections.list(super.listOptions()));
        return newVector.elements();
    }

    public void setOptions(String[] options) throws Exception {
        String seed = Utils.getOption('S', options);
        if(seed.length() != 0) {
            this.setSeed(Integer.parseInt(seed));
        } else {
            this.setSeed(1);
        }

        super.setOptions(options);
    }

    public String[] getOptions() {
        Vector options = new Vector();
        options.add("-S");
        options.add("" + this.getSeed());
        Collections.addAll(options, super.getOptions());
        return (String[])options.toArray(new String[0]);
    }

    public String seedTipText() {
        return "The random number seed to be used.";
    }

    public void setSeed(int seed) {
        this.m_Seed = seed;
    }

    public int getSeed() {
        return this.m_Seed;
    }
}

