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
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by fsfdsdf on 6/8/2015.
 */
@ScriptManifest(authors = { "Peticca10" }, name = "AIOChopper++", category = "WoodCutting")
public class AIOChopper extends Script implements Painting {

    @Override
    public void onPaint(Graphics graphics) {

    }

    public static void main(String[] args) {
        GUI.main(args);
    }

    @Override
    public void run() {

    }

}
