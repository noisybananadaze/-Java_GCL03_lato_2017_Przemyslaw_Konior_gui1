package example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Program
{
	private static String addres="students.txt";
	public static void main( String[] args ) throws Exception
	{
		final Logger[] loggers = new Logger[]
		{
			new ConsoleLogger(),
			new GuiLoger(),
		};
		Crawler C=new Crawler(addres);
		C.addIterationStartedListener((iteration)->System.out.println("Rozpoczeto iteracje "+iteration));
		C.addIterationComplitedListener(iteration->System.out.println("Zakonczono iteracje\n"));
		C.addStudentaddedListener((Student)->loggers[0].log("ADDED",Student));
		C.addStudentaddedListener((Student)->loggers[1].log("ADDED",Student));
		C.addStudentremovedListener((Student)->loggers[0].log("REMOVED",Student));
		C.addStudentremovedListener((Student)->loggers[1].log("REMOVED",Student));
		try {
			C.run();
		}catch (CrawlerException e){
			e.printStackTrace();
			e.toString();
		}
			catch(Exception e) {

			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
	/*public static void main(String[] args)throws Exception{

		//List<Student> studentsList= StudentsParser.parse(new File("Students.txt"));
		launch(args);
	}
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

		Scene scene = new Scene(pane, 410, 420);
		primaryStage.setTitle("Crawler");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	*/
}
