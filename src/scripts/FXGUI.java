package scripts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

        Parent root = FXMLLoader.load(new URL("https://raw.githubusercontent.com/Cuhlifa/AIOChopper/master/src/scripts/FXGUI.java"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("AIOChopper");
        primaryStage.show();

    }

}
