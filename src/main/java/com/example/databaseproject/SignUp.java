package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {
    @FXML
    private TextField address;

    @FXML
    private ComboBox<Integer> age;

    @FXML
    private TextField email;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private Button logInButton;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    private Button signUpButton;

    @FXML
    private CheckBox tagles;

    @FXML
    private TextField usreName;


    public void initialize() {

        gender.getItems().addAll("M", "F");
        age.getItems().addAll(18, 21, 25, 30, 35, 40, 45, 50);
        age.setEditable(true);
    }

    public void signUp() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement=connection.createStatement();
        String string="insert into person (name,username,password,address,email,phone,gender,age)" +
                "values ('"+this.name.getText()+"','"+this.usreName.getText()+"',"+Integer.parseInt(this.password.getText())+",'"+
                this.address.getText()+"','"+this.email.getText()+"','"+Integer.parseInt(this.phone.getText())+"','"+
                this.gender.getValue()+"',"+this.age.getValue()+")";
        statement.executeUpdate(string);
        connection.close();
          //  JOptionPane.showMessageDialog(null,"tag is selected nnnnnn !");
    }

}
