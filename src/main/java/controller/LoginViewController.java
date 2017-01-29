package controller;

/**
 * Created by BAHA on 21/01/2017.
 */

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


public class LoginViewController {
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

    private boolean loginSuccessful() {
        return txtUsername.getText().equals("test") && txtPassword.getText().equals("test");
    }

    private void setOnKeyPressed() {
        root.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER) && loginSuccessful())
                animateWhenLoginSuccess();
            else
                animateWhenBadLogin();
        });
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
