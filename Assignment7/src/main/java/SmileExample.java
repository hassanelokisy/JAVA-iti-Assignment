import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;
import smile.io.Read;
import smile.plot.swing.Histogram;
import smile.regression.RandomForest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.List;

public class SmileExample {

    public static void main(String[] args) {
        try {
            DataFrame df = Read.csv("titanic_train.csv", CSVFormat.DEFAULT.withFirstRecordAsHeader());
            System.out.println(df.summary());
            System.out.println(df.schema());
            df = df.select("PassengerId", "Pclass", "Age", "SibSp", "Name", "Parch", "Sex", "Survived");
            df = df.merge(IntVector.of("PclassValues", encodeColumn(df, "Pclass")));
            df = df.merge(IntVector.of("Gender", encodeColumn(df, "Sex")));
            df = df.drop("Pclass").drop("Sex").drop("Name");
            df = df.omitNullRows();
            SmileExample.eda(df);
            RandomForest model = RandomForest.fit(Formula.lhs("Survived"), df);
            System.out.println(model.metrics());
        } catch (IOException | URISyntaxException | InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void eda(DataFrame df) throws InterruptedException, InvocationTargetException {

        df = df.omitNullRows();
        DataFrame survivedDf = DataFrame.of(df.stream().filter(tuple -> tuple.get("Survived").equals(1)));
        DataFrame notSurvivedDf = DataFrame.of(df.stream().filter(tuple -> tuple.get("Survived").equals(0)));

        System.out.println("==========Survived==================");
        System.out.println(survivedDf.summary());
        System.out.println("==========Not Survived==================");
        System.out.println(notSurvivedDf.summary());

        Histogram.of(survivedDf.doubleVector("Age").toDoubleArray())
                .canvas()
                .setAxisLabel(0, "Age")
                .setAxisLabel(1, "Freq")
                .window();
//   Histogram.of (titanicSurvived.doubleVector ("Age").toDoubleArray (), 15, false)
//                .canvas ().setAxisLabels ("Age", "Count")
//                .setTitle ("Age frequencies among surviving passengers")
//                .window ();
//        Histogram.of(survivedDf.doubleVector("Age").toDoubleArray())
//                .canvas().setAxisLabel(0,"Age").setAxisLabel(1,"Count")
//                .setTitle("Age frequencies among surviving passengers")
//                .window();


    }

    public static int[] encodeColumn(DataFrame df, String columnName) {
        List<String> uniqueValues = df.stringVector(columnName).distinct();
        return df.stringVector(columnName).factorize(new NominalScale(uniqueValues)).toIntArray();
    }

}
