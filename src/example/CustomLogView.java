package example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.Date;

public class CustomLogView extends AnchorPane {

    private static TextArea textArea=new TextArea();

    public static TextArea createLogView(){

        textArea.setEditable(false);



        return textArea;
    }

    static TextArea getTextArea(){
        return textArea;
    }
}
