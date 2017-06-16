package example;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class CustomTableView  extends AnchorPane  {
    private static TableView<Student> table=new TableView<Student>();
    final static ObservableList<Student> studentList=CustomTabPane.getStudentList() ;

    public static TableView<Student> createTableView() throws  Exception{



        table.setEditable(false);


        TableColumn<Student,String> firstnameColumn=new TableColumn<Student,String>("First Name");
        firstnameColumn.setMinWidth(100);
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        CustomBarChart.updateChartSeries();


        TableColumn<Student,String> lastnameColumn=new TableColumn<Student,String>("Last Name");
        lastnameColumn.setMinWidth(100);
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));

        TableColumn<Student,Double> markColumn =new TableColumn<Student,Double>("Mark");
        markColumn.setMinWidth(100);
        markColumn.setCellValueFactory(new PropertyValueFactory<Student,Double>("Mark"));

        TableColumn<Student,Integer> ageColumn=new TableColumn<Student,Integer>("Age");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student,Integer>("Age"));

        table.setItems(studentList);
        table.getColumns().addAll(firstnameColumn,lastnameColumn,markColumn,ageColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }
}
