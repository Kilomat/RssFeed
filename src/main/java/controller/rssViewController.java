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
import model.ChannelInfo;
import model.Main;
import controller.LoginViewController;
import sun.net.ProgressSource;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


/**
 * Created by BAHA on 22/01/2017.
 */
public class rssViewController {

    private RetrofitFactory retrofitFactory = new RetrofitFactory();

    @FXML
    private WebView webView;

    @FXML
    public static ListView<String> rssListview;

    @FXML
     public static ListView<String> rssListviewItem;

    @FXML
    private TextField filterField;



    static ObservableList<String> list = FXCollections.observableArrayList("Mark", "tom", "Mark", "tom","Mark", "tom","Mark", "tom","Mark", "tom");

    @FXML
    private void initialize() {

        ///sav token
        Preferences prefs = Preferences.userNodeForPackage(controller.RetrofitFactory.class);
        // Preference key name
        final String PREF_NAME = "token";
        String defaultValue = "token";

        retrofitFactory.getChannels(prefs.get(PREF_NAME, defaultValue));

        WebEngine engine = webView.getEngine();
        engine.load("http://www.google.com");

    }

    public static void getChannelsSuccess(List<ChannelInfo> channels) {

        //ObservableList<String> list = FXCollections.observableArrayList(channels);

        //List<ChannelInfo> changesList = channels;

        //ObservableList<String> list = new ObservableList<String>()

        //changesList.forEach(change -> System.out.println(change.title));


       rssListview.setItems(list);
    //        rssListviewItem.setItems(list);

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
