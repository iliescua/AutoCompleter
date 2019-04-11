/*
* CS2852
* Fall 2018
* Lab 4 - Lab4 Class
* Created: 9/29/2018
*/
package iliescua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the driver class and it used to run the program
 */
public class Lab4 extends Application {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 500;

    /**
     * This method is used to set up the GUI
     * @param stage sets the GUI up
     * @throws Exception throws the exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader firstLoader = new FXMLLoader();
        Parent root = firstLoader.load(getClass()
                .getResource("Lab4Controller.fxml").openStream());
        stage.setTitle("Auto Completer");
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}