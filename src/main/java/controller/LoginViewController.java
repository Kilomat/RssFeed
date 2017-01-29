package controller;

/**
 * Created by BAHA on 21/01/2017.
 */

import com.sun.tools.javac.util.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.AnimationGenerator;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.util.prefs.Preferences;


import model.UserInfo;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class LoginViewController {

    private static final String TAG = "SignUp";
    private UserInfo user;
    private RetrofitFactory retrofitFactory = new RetrofitFactory();
    static boolean success_signup = false;

    @FXML
    private Text actiontarget;

    @FXML
    private GridPane root;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label loginLabel, registerLabel;

    private  final AnimationGenerator animationGenerator;

    public LoginViewController() {
        animationGenerator = new AnimationGenerator();
        this.user = new UserInfo();
    }

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Connexion...");
    }

    @FXML
    private void mouseMovedLoginLabel() {
        animationGenerator.applyFadeAnimationOn(loginLabel, 500, 1.0f, 0.7f, null);
    }

    @FXML
    private void mouseMovedRegisterLabel() {
        animationGenerator.applyFadeAnimationOn(registerLabel, 500, 1.0f, 0.7f, null);
    }

    @FXML
    private void mouseExitedLoginLabel() {
        animationGenerator.applyFadeAnimationOn(loginLabel, 500, 0.7f, 1.0f, null);
    }

    @FXML
    private void mouseExitedRegisterLabel() {
        animationGenerator.applyFadeAnimationOn(registerLabel, 500, 0.7f, 1.0f, null);
    }

    @FXML
    private void login() {
        if(loginSuccessful())
            animateWhenLoginSuccess();
        else
            animateWhenBadLogin();
    }

    @FXML
    private void signup() {
        if(signUpSuccessful())
            animateWhenSignUpSuccess();
    }

    static final String BASE_URL = "";



    public static void authenticateSuccess(JSONObject res) {
        ///sav token
        Preferences prefs = Preferences.userNodeForPackage(controller.RetrofitFactory.class);
        // Preference key name
        final String PREF_NAME = "token";
        String defaultValue = "token";
        String propertyValue = prefs.get(PREF_NAME, defaultValue);
        
        if (propertyValue.isEmpty()) {
            success_signup = false;
        }
        else
            success_signup = true;

    }

    public static void authenticateError(JSONObject res) {
        try {
            //res.getString("message")
            System.out.println(res.getString("message"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean loginSuccessful() {


        String login = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        user.setLogin(login);
        user.setPassword(password);
        retrofitFactory.loginUser(user);

        return success_signup;
    }

    private boolean signUpSuccessful() {

        String login = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        user.setLogin(login);
        user.setPassword(password);
        retrofitFactory.signupUser(user);

        return success_signup;
    }

    private void setOnKeyPressed() {
        root.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER) && loginSuccessful())
                animateWhenLoginSuccess();
            else
                animateWhenBadLogin();
        });
    }

    private void animateWhenSignUpSuccess() {
        try {
            Parent main = FXMLLoader.load(getClass().getResource("/rssView.fxml"));
            StackPane temp = new StackPane();
            animationGenerator.applyFadeAnimationOn(root, 1000, 1.0f, 0f, event -> {
                temp.setOpacity(0);
                model.Main.Secondstage.setScene(new Scene(temp, 800, 700));
                animationGenerator.applyFadeAnimationOn(temp, 1000, 0f, 1.0f, event1 -> {
                    animationGenerator.applyFadeAnimationOn(temp, 1000, 1.0f, 0f, event2 -> {
                        model.Main.Secondstage.setScene(new Scene(main, 800, 700));
                        animationGenerator.applyFadeAnimationOn(main, 1000, 0f, 1.0f, null);
                    });
                });
            });
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void animateWhenLoginSuccess() {
        try {
            Parent main = FXMLLoader.load(getClass().getResource("/rssView.fxml"));
            StackPane temp = new StackPane();
            animationGenerator.applyFadeAnimationOn(root, 1000, 1.0f, 0f, event -> {
                temp.setOpacity(0);
                model.Main.Secondstage.setScene(new Scene(temp, 800, 700));
                animationGenerator.applyFadeAnimationOn(temp, 1000, 0f, 1.0f, event1 -> {
                    animationGenerator.applyFadeAnimationOn(temp, 1000, 1.0f, 0f, event2 -> {
                        model.Main.Secondstage.setScene(new Scene(main, 800, 700));
                        animationGenerator.applyFadeAnimationOn(main, 1000, 0f, 1.0f, null);
                    });
                });
            });
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void animateWhenBadLogin() {
        try {
            StackPane temp = new StackPane();
            Parent root = FXMLLoader.load(getClass().getResource("/loginView.fxml"));
            animationGenerator.applyFadeAnimationOn(root, 1000, 1.0f, 0f, event -> {
                temp.setOpacity(0f);
                model.Main.Secondstage.setScene(new Scene(temp, 800, 700));
                animationGenerator.applyFadeAnimationOn(temp, 1000, 0f, 1.0f, event1 -> {
                    root.setOpacity(0f);
                    model.Main.Secondstage.setScene(new Scene(root, 800, 700));
                    animationGenerator.applyFadeAnimationOn(root, 1000, 0f, 1.0f, null);
                });
            });
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
