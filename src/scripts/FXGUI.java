package scripts;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import sun.nio.ch.ThreadPool;

import java.net.URL;

/**
 * Created by fsfdsdf on 6/8/2015.
 */
public class FXGUI extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(new URL("https://raw.githubusercontent.com/Cuhlifa/AIOChopper/master/src/scripts/GUI.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
;       primaryStage.setTitle("AIOChopper");
        primaryStage.show();

    }

}
