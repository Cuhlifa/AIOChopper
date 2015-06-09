package scripts;

import com.sun.javafx.application.PlatformImpl;

import java.awt.*;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import netscape.javascript.JSObject;

  
/** 
 * SwingFXWebView 
 */  
public class JavaFXUI extends JPanel {  

    private Stage stage;  
    private WebView browser;  
    private JFXPanel jfxPanel;  
    final static JFrame frame = new JFrame(); 
  
    
    public JavaFXUI(){  
        initComponents();
        Color color = new Color(0,0,0,0);
    }
  
    public static void main(String args[]){  
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {  
	                frame.setTitle("AIOChopper++");
	                frame.setMinimumSize(new Dimension(500, 700));  
	                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	                frame.setVisible(true);
	                frame.getContentPane().add(new JavaFXUI());
	            }  
	        });
    }
     
    private void initComponents(){  
        jfxPanel = new JFXPanel();  
        createScene();  
        add(jfxPanel);
    }

    private void createScene() {
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  

                stage = new Stage();  
                 
                stage.setTitle("Hello Java FX");  
                StackPane root =  new StackPane();
                Scene scene = new Scene(root, 500,700);
                stage.setScene(scene);  
                Platform.setImplicitExit(false);
                 
                browser = new WebView();
                final WebEngine webEngine = browser.getEngine();
                webEngine.setJavaScriptEnabled(true);
                webEngine.load("http://cuhlifa.github.io/AIOChopper/GUI/");
                webEngine.getLoadWorker().stateProperty().addListener(
                        new ChangeListener<Worker.State>() {
                            @Override
                            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                                if (newState == Worker.State.SUCCEEDED) {                        
                                    JSObject jso = (JSObject) webEngine.executeScript("window");
                                    jso.setMember("java", new Bridge(webEngine));
                                }

                            }
                        });
                ObservableList<Node> children = root.getChildren();
                children.add(browser);                     
                
                jfxPanel.setScene(scene);  
                System.out.println("Main FX UI Successfully Created!");
            }  
        });  
    }
    public class Bridge {
        WebEngine engine;
        boolean runOnce = true;
        Bridge(WebEngine engine){
            this.engine=engine;
	          engine.executeScript("exit='"+exit()+"'; ");
        }
        public String exit() {
        	if(runOnce){
        		Exception e = new Exception();
        		e.fillInStackTrace();
        		String methodName = e.getStackTrace()[0].getMethodName();
        		runOnce=false;
        		System.out.println("FX UI Exit Hooked on: "+"java."+methodName+"()");
        		return "java."+methodName+"()";
        	}
        	String EndProduct = ""+ engine.executeScript("$('#td10').text();");
        	frame.dispose();
        	Thread.currentThread().stop();
        	return " ";
        }
   }


}