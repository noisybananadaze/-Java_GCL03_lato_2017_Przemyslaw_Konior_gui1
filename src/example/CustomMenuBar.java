package example;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Region;

public class CustomMenuBar extends MenuBar{


    public static MenuBar createMenuBar(){
        MenuBar menuBar=new MenuBar();

        //Menu
        Menu program=new Menu("Program");
        Menu about=new Menu("About");

        menuBar.getMenus().addAll(program,about);
        //Menu items

        //closeItem
        MenuItem closeItem=new MenuItem("Close ");
        closeItem.setMnemonicParsing(true);
        closeItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        closeItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        //aboutItem
        MenuItem aboutItem=new MenuItem("About");
        aboutItem.setMnemonicParsing(true);
        //aboutItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        aboutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Przemyslaw Konior javaLab",ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.setTitle("About");
                alert.setHeaderText("info");
                alert.setContentText("Przemyslaw Konior javaLab");
                //alert.initOwner(primaryStage);
                alert.show();
            }
        });

        program.getItems().addAll(closeItem);
        about.getItems().addAll(aboutItem);


        return menuBar;
    }
}
