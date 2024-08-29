package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
public class reviews  implements Initializable {
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

    @FXML
    private RadioButton E1;

    @FXML
    private RadioButton E2;

    @FXML
    private RadioButton E3;

    @FXML
    private RadioButton E4;

    @FXML
    private RadioButton E5;

    @FXML
    private RadioButton F1;

    @FXML
    private RadioButton F2;

    @FXML
    private RadioButton F3;

    @FXML
    private RadioButton F4;

    @FXML
    private RadioButton F5;
    @FXML
    private Label numofRev;
@FXML
private Label AVG;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            TotalReviews();
            avg();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void submitInformation() throws SQLException {

        if (!isAllOptionsSelected()) {
            JOptionPane.showMessageDialog(null, "Please make sure you have filled in all options!");
            return;
        }

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        if(note1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "please write the your notes");
        }
        else {
            String string = "insert into reviews (rate1,rate2,rate3,rate4,rate5,rate6,note) values("
                    + getSelectedEvaluation(A1, A2, A3, A4, A5) + ","
                    + getSelectedEvaluation(B1, B2, B3, B4, B5) + ","
                    + getSelectedEvaluation(C1, C2, C3, C4, C5) + ","
                    + getSelectedEvaluation(D1, D2, D3, D4, D5) + ","
                    + getSelectedEvaluation(E1, E2, E3, E4, E5) + ","
                    + getSelectedEvaluation(F1, F2, F3, F4, F5) + ",'"
                    + note1.getText() + "')";
            statement.executeUpdate(string);
            connection.close();

            JOptionPane.showMessageDialog(null, "Thank you");

            resetRadioButtons(A1, A2, A3, A4, A5);
            resetRadioButtons(B1, B2, B3, B4, B5);
            resetRadioButtons(C1, C2, C3, C4, C5);
            resetRadioButtons(D1, D2, D3, D4, D5);
            resetRadioButtons(E1, E2, E3, E4, E5);
            resetRadioButtons(F1, F2, F3, F4, F5);
            note1.clear();
        }
    }

    private boolean isAllOptionsSelected() {
        return getSelectedEvaluation(A1, A2, A3, A4, A5) != 0 &&
                getSelectedEvaluation(B1, B2, B3, B4, B5) != 0 &&
                getSelectedEvaluation(C1, C2, C3, C4, C5) != 0 &&
                getSelectedEvaluation(D1, D2, D3, D4, D5) != 0 &&
                getSelectedEvaluation(E1, E2, E3, E4, E5) != 0 &&
                getSelectedEvaluation(F1, F2, F3, F4, F5) != 0;
    }

    private void resetRadioButtons(RadioButton... buttons) {
        for (RadioButton button : buttons) {
            button.setSelected(false);
        }
    }

    private int getSelectedEvaluation(RadioButton... buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                return i + 1;
            }
        }
        return 0;
    }
    public void TotalReviews() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        String sql = "select count(rate1) as totalReviews from reviews";


        ResultSet resultSet = statement.executeQuery(sql);


        if (resultSet.next()) {
             numofRev.setText(String.valueOf(resultSet.getInt("totalReviews")));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
    public void avg() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();


        String sql = "SELECT (avg(rate1) + avg(rate2) +avg(rate3) + avg(rate4) + avg(rate5) + avg(rate6)) / 6.0 AS avg FROM reviews";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            double average = resultSet.getDouble("avg");
            String formattedAverage = String.format(Locale.US,"%.2f", average);
            AVG.setText(formattedAverage);
        }


        resultSet.close();
        statement.close();
        connection.close();
    }


}
