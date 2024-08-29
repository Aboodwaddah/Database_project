package com.example.databaseproject;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import  java.net.URL;
public class LoginController implements Initializable {
    @FXML
    private  TextField Username;
    @FXML
    private PasswordField Password;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button employeeButton;
    @FXML
    public AnchorPane ap;
    @FXML
    private AnchorPane primaryAp;
    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField email;

    @FXML
    public TextField gender;


    @FXML
    private TextField name;

    @FXML
    private PasswordField password;


    @FXML
    private TextField phone;

    @FXML
    private TextField usreName;

    @FXML
    private Pane SignupPane;
    @FXML
    private Label userid;


    private final String[] Gender =
        {
    "male",
    "female"
    };


    public void login(ActionEvent event) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

            pstmt = conn.prepareStatement(
                    "SELECT person_type, id_person, name FROM person WHERE username = ? AND password = ?");

            pstmt.setString(1, this.Username.getText());
            pstmt.setInt(2, Integer.parseInt(this.Password.getText()));

            rs = pstmt.executeQuery();

            if (rs.next()) {
                String personType = rs.getString("person_type");
                System.out.println("Person type retrieved: " + personType);
                CarPageController.id1 = rs.getInt("id_person");

                // Handle different person types
                if ("admin".equals(personType)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else if ("employee".equals(personType)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
                    Parent root = loader.load();
                    AnchorPane ap = (AnchorPane) loader.getNamespace().get("ap");
                    Parent list1Root = FXMLLoader.load(getClass().getResource("list1.fxml"));
                    ap.getChildren().clear();
                    ap.getChildren().add(list1Root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else if ("customer".equals(personType)) {
                    userid.setText(String.valueOf(rs.getInt("id_person")));
                    System.out.println(userid.getText());

                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Welcome.fxml"));
                    Parent welcomeRoot = loader1.load();

                    Label WelcomeName = (Label) loader1.getNamespace().get("WelcomeName");
                    WelcomeName.setText(rs.getString("name"));

                    PauseTransition changeTextPause = new PauseTransition(Duration.seconds(3));
                    ResultSet finalRs = rs;
                    changeTextPause.setOnFinished(event1 -> {
                        try {
                            WelcomeName.setText(finalRs.getString("name"));
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Error updating welcome message.", "Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    });

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene welcomeScene = new Scene(welcomeRoot);
                    stage.setScene(welcomeScene);
                    stage.show();
                    stage.setResizable(false);

                    PauseTransition switchScenePause = new PauseTransition(Duration.seconds(5));
                    switchScenePause.setOnFinished(e -> {
                        try {
                            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("list.fxml"));
                            Parent root = loader2.load();

                            AnchorPane ap = (AnchorPane) loader2.getNamespace().get("ap");
                            Parent list1Root = FXMLLoader.load(getClass().getResource("list1.fxml"));
                            ap.getChildren().clear();
                            ap.getChildren().add(list1Root);

                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error loading the list page.", "Error", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    });

                    switchScenePause.play();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is incorrect.", "Login Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("No user found with the given username and password.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error occurred during login.", "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading FXML files or transitioning between scenes.", "IO Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input format for password.", "Input Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Ensure resources are closed
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing database resources.", "Database Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
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
    private void page3(ActionEvent event) throws IOException {

        loadPage("page3");
    }

    @FXML
    private void signupPage(ActionEvent event) throws IOException {
        loadPage1("signUp");
    }


    public void loadPage(String page) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        ap.getChildren().clear();
        ap.getChildren().addAll(root);

    }

    public void loadPage1(String page) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        primaryAp.getChildren().clear();
        primaryAp.getChildren().add(root);
    }

    public TextField getUsernameField() {
        return Username;
    }


    public void signUp() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

            String genderText = this.gender.getText().trim();
            if (!genderText.equals("male") && !genderText.equals("female")) {
                JOptionPane.showMessageDialog(null, "Please enter the correct format for gender (male) or (female).");
                return;
            }

            String sql = "INSERT INTO person (name, username, password, address, email, phone, gender, age) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, this.name.getText().trim());
            statement.setString(2, this.usreName.getText().trim());
            statement.setInt(3, Integer.parseInt(this.password.getText().trim()));
            statement.setString(4, this.address.getText().trim());
            statement.setString(5, this.email.getText().trim());
            statement.setInt(6, Integer.parseInt(this.phone.getText().trim()));
            statement.setString(7, genderText);
            statement.setInt(8, Integer.parseInt(this.age.getText().trim()));

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sign up successful!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for password, phone, and age.");
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while interacting with the database.");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "An error occurred while closing the database connection.");
                e.printStackTrace();
            }
        }
    }
    public void goSignup() {
        SignupPane.setVisible(true);
    }
    public void returnSignup() {
        SignupPane.setVisible(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }





};