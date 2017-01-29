package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by BAHA on 21/01/2017.
 */
public  class Main extends Application {


    static Scene scene;
    public static Stage Secondstage;

    @Override
    public void start(Stage stage)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/loginView.fxml"));

            scene = new Scene(root, 500, 500);

            stage.setTitle("RssFeed Reader");
            stage.setScene(scene);
            stage.show();
            Secondstage = stage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // body of main method follows
        launch(args);
    }
}
