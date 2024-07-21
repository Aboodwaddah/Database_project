package com.example.databaseproject;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

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

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane ap;
    @FXML
    private AnchorPane primaryAp;
@FXML
private AnchorPane pab;



    public void login(ActionEvent event) throws IOException {
        if (Username.getText().equals("abood") && Password.getText().equals("1234")) {
            wrong.setVisible(false);
            sucess.setVisible(true);
            sucess.setText("Correct");


            FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
            root = loader.load();


             ap = (AnchorPane) loader.getNamespace().get("ap");


            Parent list1Root = FXMLLoader.load(getClass().getResource("list1.fxml"));
            ap.getChildren().clear();
            ap.getChildren().add(list1Root);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            sucess.setVisible(false);
            wrong.setVisible(true);
            wrong.setText("Incorrect username or password");
        }
    }

    public void BuyCarPage(ActionEvent event) throws IOException
    {
        loadPage3("BuyCar");
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {

        loadPage("list1");
    }

    @FXML
    private void page1(ActionEvent event) throws IOException {

        loadPage("page1");
    }

    @FXML
    private void page2(ActionEvent event) throws IOException {

        loadPage("page2");
    }

    @FXML
    private void page3(ActionEvent event) throws IOException
    {

        loadPage("page3");
    }
    @FXML
    private void signupPage(ActionEvent event) throws IOException
    {
        loadPage1("signUp");
    }


    public void loadPage(String page) throws IOException
    {

        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page +".fxml")) );
       // ap.getChildren().clear();
        //ap.getChildren().add(root);
        ap.getChildren().setAll(root);

    }
    public void loadPage1(String page) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(page +".fxml"));
        primaryAp.getChildren().clear();
        primaryAp.getChildren().add(root);
    }
    public void loadPage3(String page) throws IOException
    {

        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page +".fxml")) );
        // ap.getChildren().clear();
        //ap.getChildren().add(root);
        pab.getChildren().setAll(root);

    }



}