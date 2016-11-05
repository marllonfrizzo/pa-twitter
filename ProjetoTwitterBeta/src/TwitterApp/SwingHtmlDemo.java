package TwitterApp;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingHtmlDemo {
    
  public void main(String url){

    SwingUtilities.invokeLater(new Runnable() {
    @Override
      public void run() {
        ApplicationFrame mainFrame = new ApplicationFrame(url);
        mainFrame.setVisible(true);
      }
    });

  }

}

/**
* Main window used to display some HTML content.
*/
class ApplicationFrame extends JFrame{

  JFXPanel javafxPanel;
  WebView webComponent;
  JPanel mainPanel;

  JTextField urlField;
  JButton goButton;

  public ApplicationFrame(String url){

    javafxPanel = new JFXPanel();

    initSwingComponents();

    loadJavaFXScene(url);
  }

  /**
  * Instantiate the Swing compoents to be used
  */
  private void initSwingComponents(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
      }

  /**
  * Instantiate the JavaFX Components in
  * the JavaFX Application Thread.
  */
  private void loadJavaFXScene(String url){
    Platform.runLater(new Runnable() {
      @Override
      public void run() {

        BorderPane borderPane = new BorderPane();
        webComponent = new WebView();

        webComponent.getEngine().load(url);
       
        borderPane.setCenter(webComponent);
        Scene scene = new Scene(borderPane,400,400);
        javafxPanel.setScene(scene);

      }
    });
  }
}