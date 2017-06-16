package example;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.List;

public class CustomBarChart extends AnchorPane{

    static XYChart.Series<String,Number> series =new XYChart.Series<String,Number>();;
    static int[] counter=new int[6];

    public static BarChart createBarChart() throws Exception{

        for (int n:counter ) {
            n=0;
        }

        CategoryAxis xAxis=new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mark");
        yAxis.setLabel("Count");

        final BarChart<String,Number> barChart =new BarChart<String,Number>(xAxis,yAxis);
        barChart.setTitle("Distribution of marks");
        series =new XYChart.Series<String,Number>();
        series.setName("Marks");



        series.getData().add(new XYChart.Data("2.0",counter[0]));
        series.getData().add(new XYChart.Data("3.0",counter[1]));
        series.getData().add(new XYChart.Data("3.5",counter[2]));
        series.getData().add(new XYChart.Data("4.0",counter[3]));
        series.getData().add(new XYChart.Data("4.5",counter[4]));
        series.getData().add(new XYChart.Data("5.0",counter[5]));

        barChart.getData().add(series);


        return barChart;
    }
    public static void updateChartSeries(){
        int i = 0;
        for(XYChart.Data<String, Number> data : series.getData()){
            Number tmp = data.getYValue();
            if(counter[i]> tmp.intValue())data.setYValue(counter[i]);
            else if(counter[i]<tmp.intValue()) data.setYValue(counter[i]);
            i++;
        }

    }

    public static void increment(Student el)
    {
        if(el.getMark()==2.0) counter[0]++;
        else if(el.getMark()==3.0) counter[1]++;
        else if(el.getMark()==3.5) counter[2]++;
        else if(el.getMark()==4.0) counter[3]++;
        else if(el.getMark()==4.5) counter[4]++;
        else if(el.getMark()==5.0) counter[5]++;
        CustomBarChart.updateChartSeries();
    }

    public static void decrement(Student el)
    {
        if(el.getMark()==2.0) counter[0]--;
        else if(el.getMark()==3.0) counter[1]--;
        else if(el.getMark()==3.5) counter[2]--;
        else if(el.getMark()==4.0) counter[3]--;
        else if(el.getMark()==4.5) counter[4]--;
        else if(el.getMark()==5.0) counter[5]--;
        CustomBarChart.updateChartSeries();
    }


}
