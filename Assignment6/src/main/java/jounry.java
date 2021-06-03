import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinery.DataFrame;
public class jounry {
       public static void main(String args[]) {
        DataFrame<Object>  df;
        try {
            df = DataFrame.readCsv ("titanic.csv")
                    .retain("survived","age","sibsp","parch","ticket","fare");
            System.out.println("Mean :");
            df.mean().iterrows ().forEachRemaining (System.out::println);
            System.out.println("Min :");
            df.min().iterrows ().forEachRemaining (System.out::println);
            
            System.out.println("Min :");
            df.max().iterrows ().forEachRemaining (System.out::println);
            System.out.println("is data frame empty :");
            df.isEmpty();
        } catch (IOException ex) {
            Logger.getLogger(jounry.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
