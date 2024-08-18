package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class SellCar {
    @FXML
    private TextField body;

    @FXML
    private TextField condition;

    @FXML
    private TextField distance;

    @FXML
    private TextField email;

    @FXML
    private TextField engine;

    @FXML
    private TextField fuel;

    @FXML
    private TextField make;

    @FXML
    private TextField phone;

    @FXML
    private TextField price;

    @FXML
    private TextField trans;



    @FXML
    private TextField year;

    @FXML
    private TextField model;

    @FXML
    private TextField color;

    public void addCar() throws SQLException, IOException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");


        String sql = "INSERT INTO Car (make, model, condition, year, price, engine_capacity, color, fuel_type, transmission, body_style, distance, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, this.make.getText());
        statement.setString(2, this.model.getText());
        statement.setString(3, this.condition.getText());
        statement.setInt(4, Integer.parseInt(this.year.getText()));
        statement.setInt(5, Integer.parseInt(this.price.getText()));
        statement.setInt(6, Integer.parseInt(this.engine.getText()));
        statement.setString(7, this.color.getText());
        statement.setString(8, this.fuel.getText());
        statement.setString(9, this.trans.getText());
        statement.setString(10, this.body.getText());
        statement.setInt(11, Integer.parseInt(this.distance.getText()));

        // Handle the image file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            statement.setBinaryStream(12, new FileInputStream(file));
        } else {

            statement.setNull(12, java.sql.Types.BINARY);
        }


        statement.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Car added successfully");
        alert.showAndWait();
        connection.close();
    }

    private String encodeFileToBase64(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStream.read(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

}
