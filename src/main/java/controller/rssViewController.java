package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Main;
import controller.LoginViewController;
import sun.net.ProgressSource;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by BAHA on 22/01/2017.
 */
public class rssViewController {


    @FXML
    private WebView webView;

    @FXML
    public ListView<String> rssListview;

    @FXML
     public ListView<String> rssListviewItem;

    @FXML
    private TextField filterField;


    ObservableList<String> list = FXCollections.observableArrayList("Mark", "tom", "Mark", "tom","Mark", "tom","Mark", "tom","Mark", "tom");

    @FXML
    private void initialize() {
        WebEngine engine = webView.getEngine();
        engine.load("http://www.google.com");
        rssListview.setItems(list);
        rssListviewItem.setItems(list);

    }

    @FXML
    private void closeAction(ActionEvent actionEvent) {
    Main.Secondstage.close();
    }

    @FXML
    private void logoutAction(ActionEvent actionEvent) throws  Exception{
        //Main.Secondstage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/loginView.fxml"));
        model.Main.Secondstage.setScene(new Scene(root, 800, 700));
    }

}
