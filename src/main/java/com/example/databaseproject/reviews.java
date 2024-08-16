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

    @FXML
    private RadioButton D1;

    @FXML
    private RadioButton D2;

    @FXML
    private RadioButton D3;

    @FXML
    private RadioButton D4;

    @FXML
    private RadioButton D5;

    public void submitInformation() throws SQLException {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement=connection.createStatement();
            String string="insert into reviews (rate1,rate2,rate3,note) values("+getSelectedEvaluation(A1, A2, A3, A4, A5)+","
                    +getSelectedEvaluation(B1, B2, B3, B4, B5)+","+getSelectedEvaluation(C1, C2, C3, C4, C5)+",'"+note1.getText()+"')";
            statement.executeUpdate(string);
            connection.close();


    }
    private int getSelectedEvaluation(RadioButton... buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                return i + 1;
            }
        }
        JOptionPane.showMessageDialog(null,"NOT SUCCsisfuly !");
        return 0;
    }
}
