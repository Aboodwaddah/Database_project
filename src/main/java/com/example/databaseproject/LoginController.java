package com.example.databaseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.io.IOException;

public class LoginController {
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private Label sucess;
    @FXML
    private Label wrong;
    @FXML
    private Button loginButton;

private Scene scene2;
private Stage stage2;
private Parent P;




    @FXML
    public void login(ActionEvent event) throws IOException {

            if (Username.getText().equals("abood") && Password.getText().equals("1234"))
            {
                wrong.setVisible(false);
                sucess.setVisible(true);
              sucess.setText("correct");

                Parent P = FXMLLoader.load(getClass().getResource("list.fxml"));
                stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene2 = new Scene(P);
                stage2.setScene(scene2);
                stage2.show();

            }
            else {

                sucess.setVisible(false);
                wrong.setVisible(true);
                wrong.setText("Incorrect username or password");

            }
        }

}
