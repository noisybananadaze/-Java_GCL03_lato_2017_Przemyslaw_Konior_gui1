package example;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CustomTabPane {

     final static ObservableList<Student> studentList= FXCollections.observableArrayList();

    public static TabPane createTabPane() throws Exception
    {
        TabPane tabPane=new TabPane();
        //StudenstsTab
        Tab studentsTab=new Tab("Students");
        studentsTab.setClosable(false);
        TableView<Student> studentTab = CustomTableView.createTableView();
        studentsTab.setContent(studentTab);

        //LogTab
        Tab logTab=new Tab("Log");
        logTab.setClosable(false);
        TextArea logsTab=CustomLogView.createLogView();
        logTab.setContent(logsTab);

        //HistogramTab
        Tab histogramTab=new Tab("Histogram");
        histogramTab.setClosable(false);
        BarChart<String ,Number> barCharTab=CustomBarChart.createBarChart();
        histogramTab.setContent(barCharTab);
        //CustomBarChart.updateChartSeries();

        tabPane.setTranslateX(30);
        tabPane.getTabs().addAll(studentsTab,logTab,histogramTab);

        return tabPane;
    }

     static  ObservableList<Student> getStudentList() {
        return studentList;
    }

}
