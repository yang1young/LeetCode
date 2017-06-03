
import weka.classifiers.Evaluation;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.NumericToNominal;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

      /*  Instances trainData = null;
        Instances testData = null;
        Main main = new Main();

        try {
            int[] index = new int[]{19};
            trainData = main.dataConfig("/home/qiaoyang/javaProject/svmTrain/src/main/resources/normal.csv","",index,true);

            String[] RFoptions = {"-I", "100", "-K", "20", "-S", "10", "-depth", "10"};
            String[] SVMoptions = {"-S", "0", "-K", "0","-G","1","-C","10","-B"};

            Models[] myModel;
            myModel = main.buildModel(trainData,SVMoptions,RFoptions,"/home/qiaoyang/javaProject/svmTrain/src/main/resources/");

           // testData = main.dataConfig("/home/qiaoyang/javaProject/svmTrain/src/main/train.csv","",index,true);
           // myModel[0].modelEvaluate(testData);
           // myModel[1].modelEvaluate(testData);*//*


            Models model = Utils.reloadPersistModel("/home/qiaoyang/javaProject/svmTrain/src/main/resources/svm.model");
           // double[] data = new double[]{-0.998275,-0.998981,0,0,-1,9,-1,-1,-1,1,-0.992481,0,-1,-1,-1,-1,-1,-1,-0.992481,0};
           // System.out.println(model.predict(data));
            //model.crossValidate(trainData);
            model.modelEvaluate(trainData);



        } catch (Exception e) {
            e.printStackTrace();
        }*/
        ArrayList arrayList = new ArrayList();
        arrayList.add(15);
        Utils.libsvmToCsv("/media/qiaoyang/STLY/Data/Openssl-0.txt","/media/qiaoyang/STLY/Data/1.csv",15,arrayList);


    }


    public Models[] buildModel(Instances data, String[] SVMoptions,String [] RFoption,String modelpath) {

        Models[] myModel = new Models[2];
        ArrayList<Attribute> dataInfo = new ArrayList<Attribute>();
        try {

            for (int j = 0; j < data.numAttributes(); j++) {
                Attribute attribute = data.attribute(j);
                System.out.println(attribute);
                dataInfo.add(attribute);
            }
            Models model1 = null;
           model1 = new SVMModel(SVMoptions, data);
            model1.setDataInfo(dataInfo);
            Utils.persistModel(model1, modelpath + "svm.model");

            Models model2 = new RandomForestModel(RFoption, data);
            model2.setDataInfo(dataInfo);
            Utils.persistModel(model2, modelpath + "rf.model");
            myModel[0] = model1;
            myModel[1] = model2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myModel;
    }


    private Instances dataConfig(String trainDataPath,String testDataPath,int[] indexOfNominal,boolean isTrain) {
        Instances train = null;
        Instances test = null;
        ConverterUtils.DataSource source;

        try {

            source = new ConverterUtils.DataSource(trainDataPath);
            train = source.getDataSet();

            NumericToNominal convert = new NumericToNominal();
            convert.setAttributeIndicesArray(indexOfNominal);
            convert.setInputFormat(train);

            if(isTrain){
                train = Filter.useFilter(train, convert);
                train.setClassIndex(train.numAttributes() - 1);
                return train;
            }
            else {
                test = Filter.useFilter(test, convert);
                test.setClassIndex(test.numAttributes() - 1);
                return test;
            }


           /* Normalize normalize = new Normalize();
            String[] normalOptions = new String[]{"-S", "2.0", "-T", "-1.0"};
            normalize.setOptions(normalOptions);
            normalize.setInputFormat(data);
            data = Filter.useFilter(data, normalize);*/

           /* NominalToBinary nominalToBinary = new NominalToBinary();
            //String[] nominalOPtions = new String[]{"-N"};
            // nominalToBinary.setOptions(normalOptions);
            nominalToBinary.setInputFormat(data);
            data = Filter.useFilter(data, nominalToBinary);*/




        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}



