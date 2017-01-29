package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;


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

    //static final String BASE_URL = "http://lightthemup.fr.nf:3000/";


    public static void main(String[] args) {
        // body of main method follows
        launch(args);
    }
}
