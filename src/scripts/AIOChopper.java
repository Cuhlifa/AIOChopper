package scripts;

import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import java.awt.*;

/**
 * Created by fsfdsdf on 6/8/2015.
 */
@ScriptManifest(authors = { "Peticca10" }, name = "AIOChopper++", category = "WoodCutting")
public class AIOChopper extends Script implements Painting {
    @Override
    public void onPaint(Graphics graphics) {

    }

    @Override
    public void run() {
        try{
            FXGUI.main(null);
        }catch (Exception e){}
    }

}
