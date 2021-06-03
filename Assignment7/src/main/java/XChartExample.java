import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Category;
import org.knowm.xchart.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class XChartExample {

    public static void main(String[] args){
        try {
            File file= new File("titanic_csv.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

            List<TitanicPassenger> allPassanger=mapper.readValue(file,new TypeReference<List<TitanicPassenger>>(){
            });


            allPassanger.stream().forEach(System.out::println);
            XChartExample.categoryChartGraph(allPassanger);
            XChartExample.boxChartGraph(allPassanger);
            XChartExample.pieChartGraph(allPassanger);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void categoryChartGraph(List<TitanicPassenger> allPassanger){
        List<String> names = allPassanger.stream().map(TitanicPassenger::getName).limit(5).collect(Collectors.toList());
        List<Double> ages = allPassanger.stream().map(TitanicPassenger::getAge).limit(5).collect(Collectors.toList());

        CategoryChart chart=new  CategoryChartBuilder().height(700).width(1020)
                .title("Passenger Ages").xAxisTitle("Names").yAxisTitle("Ages")
                .build();

        chart.addSeries("Passenger Ages Names",names,ages);
        new SwingWrapper<CategoryChart>(chart).displayChart();

    }
    public static void boxChartGraph(List<TitanicPassenger> allPassanger){

        List<Double> ages = allPassanger.stream().map(TitanicPassenger::getAge).collect(Collectors.toList());
        BoxChart chart= new BoxChartBuilder().height(700).width(1020)
                .title("Passenger Ages").xAxisTitle("Names").yAxisTitle("Ages")
                .build();
        chart.addSeries("Ages Series Name",ages);
        new SwingWrapper<BoxChart>(chart).displayChart();

    }  
    public static void pieChartGraph(List<TitanicPassenger> allPassanger){
        Map<Integer, Long> pclassCount = allPassanger.stream().collect(Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting()));
        PieChart chart=new PieChartBuilder().height(700).width(1020)
                .title("Passenger Classes").build();
        chart.addSeries("Pclass 1",pclassCount.get(1));
        chart.addSeries("Pclass 2",pclassCount.get(2));
        chart.addSeries("Pclass 3",pclassCount.get(3));
        new SwingWrapper<PieChart>(chart).displayChart();

    }


}
