package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class reviews {
    @FXML
    private RadioButton A1;

    @FXML
    private RadioButton A2;

    @FXML
    private RadioButton A3;

    @FXML
    private RadioButton A4;

    @FXML
    private RadioButton A5;

    @FXML
    private RadioButton B1;

    @FXML
    private RadioButton B2;

    @FXML
    private RadioButton B3;

    @FXML
    private RadioButton B4;

    @FXML
    private RadioButton B5;

    @FXML
    private RadioButton C1;

    @FXML
    private RadioButton C2;

    @FXML
    private RadioButton C3;

    @FXML
    private RadioButton C4;

    @FXML
    private RadioButton C5;

    @FXML
    private TextArea note1;

    @FXML
    private Button submit;

    public void submitInformation() throws SQLException {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement=connection.createStatement();
            String strSql = "INSERT INTO reviews (note) VALUES ('"+note1.getText()+"')";
            statement.executeUpdate(strSql);
            connection.close();
    }
    private int getSelectedEvaluation(RadioButton... buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                return i + 1;
            }
        }
        return 0;
    }
}
