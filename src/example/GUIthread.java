package example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUIthread  extends Application implements Runnable{
    public void run(){launch();}

    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane = new AnchorPane();


        MenuBar menuBar = CustomMenuBar.createMenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());


        TabPane tabPane=CustomTabPane.createTabPane();
        tabPane.prefWidthProperty().bind(primaryStage.widthProperty());
        tabPane.prefHeightProperty().bind(primaryStage.heightProperty());
        AnchorPane.setLeftAnchor(tabPane, -30.0);
        AnchorPane.setTopAnchor(tabPane, 25.0);

        pane.getChildren().addAll(tabPane,menuBar);

        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Crawler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
