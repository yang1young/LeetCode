import weka.classifier.functions.LibSVMs;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.trees.RandomForest;
import weka.core.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Models implements Serializable {

    protected AbstractClassifier model;
    protected ArrayList<Attribute> dataInfo = null;

    public void setDataInfo(ArrayList<Attribute> dataInfo) {
        this.dataInfo = dataInfo;
    }

    public double predict(double[] data){
        double result = 0;
        Instances df = new Instances("predictData", dataInfo, 0);
        df.setClassIndex(df.numAttributes() - 1);

        Instance sample = new DenseInstance(1.0, data);
        sample.setDataset(df);
        System.out.println(sample);
        try {
            result = model.classifyInstance(sample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void modelEvaluate(Instances testData){
        try {
            Evaluation eval = new Evaluation(testData);
            eval.evaluateModel(model,testData);
            System.out.println("Classifer Summary INFO: " + eval.toSummaryString("\nResults\n\n", false));
            System.out.println("Classifer Detail INFO: " + eval.toClassDetailsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public double predictTest(Instance sample) {
        double res = -1;
        try {
            res = model.classifyInstance(sample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void crossValidate(Instances trainSet) {
        try {
            Evaluation eval = new Evaluation(trainSet);
            eval.crossValidateModel(model, trainSet, 3, new Random(1));
            System.out.println("Classifer Summary INFO: " + eval.toSummaryString("\nResults\n\n", false));
            System.out.println("Classifer Detail INFO: " + eval.toClassDetailsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RandomForestModel extends Models {
    private static final String[] options = {"-I", "100", "-K", "20", "-S", "10", "-depth", "10"};

    public RandomForestModel(Instances data) {
        this(options, data);
    }

    public RandomForestModel(String[] options, Instances data) {
        model = new RandomForest();
        try {
            model.setOptions(options);
            model.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






class SVMModel extends Models{
    private static final String[] options = {"-K", "0", "-D", "3"};
    protected AbstractClassifier model;

    public SVMModel(Instances data) {
        this(options, data);
    }

    public SVMModel(String[] options, Instances data) {
        model = new LibSVMs();

        try {
            model.setOptions(options);
            model.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}




