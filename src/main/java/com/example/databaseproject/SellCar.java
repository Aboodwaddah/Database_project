package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Base64;
import java.util.ResourceBundle;

public class SellCar implements Initializable {
    @FXML
    private ComboBox<String> body;

    @FXML
    private ComboBox<String> condition;

    @FXML
    private TextField distance;

    @FXML
    private TextField email;

    @FXML
    private TextField engine;

    @FXML
    private ComboBox<String> fuel;

    @FXML
    private ComboBox<String> make;

    @FXML
    private TextField phone;

    @FXML
    private TextField price;

    @FXML
    private ComboBox<String> trans;



    @FXML
    private TextField year;

    @FXML
    private TextField model;

    @FXML
    private TextField color;
    private final String[] conditions = {"", "new", "used"};
    private final String[] CarsType = {
            "",
            "bmw",
            "skoda",
            "toyota",
            "mercedes-benz",
            "audi",
            "honda",
            "ford",
            "volkswagen",
            "hyundai",
            "nissan",
            "chevrolet",
            "kia",
            "volvo",
            "tesla",
            "subaru",
            "peugeot",
            "renault",
            "jaguar",
            "land rover",
            "porsche",
            "fiat",
            "mini",
            "mitsubishi",
            "buick",
            "cadillac",
            "lincoln",
            "infiniti",
            "acura",
            "lexus",
            "mazda",
            "dodge",
            "chrysler",
            "ram",
            "gmc",
            "suzuki",
            "hummer",
            "great wall",
            "changan",
            "byd",
            "geely",
            "dongfeng",
            "nissan"
    };
    private final String[] CarStyle =
            {
                    "",
                    "sedan",
                    "suv",
                    "hatchback",
                    "convertible",
                    "coupe",
                    "pickup",
                    "van"
            };
    private final String[] Fuel = {
            "",
            "Petrol",
            "Diesel",
            "Electric",
            "Hybrid"
    };

    private final String[] Transmission = {
            "",
            "Manual",
            "Automatic"

    };

    public void addCar() {
        // Validate that all required fields are filled
        if (this.make.getValue().isEmpty() || this.model.getText().isEmpty() ||
                this.condition.getValue().isEmpty() || this.year.getText().isEmpty() ||
                this.price.getText().isEmpty() || this.engine.getText().isEmpty() ||
                this.color.getText().isEmpty() || this.fuel.getValue().isEmpty() ||
                this.trans.getValue().isEmpty() || this.body.getValue().isEmpty() ||
                this.distance.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

            String sql = "INSERT INTO Car (make, model, condition, year, price, engine_capacity, color, fuel_type, transmission, body_style, distance, image, pending,sell) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            statement = connection.prepareStatement(sql);

            statement.setString(1, this.make.getValue());
            statement.setString(2, this.model.getText());
            statement.setString(3, this.condition.getValue());
            statement.setInt(4, Integer.parseInt(this.year.getText()));
            statement.setInt(5, Integer.parseInt(this.price.getText()));
            statement.setInt(6, Integer.parseInt(this.engine.getText()));
            statement.setString(7, this.color.getText());
            statement.setString(8, this.fuel.getValue());
            statement.setString(9, this.trans.getValue());
            statement.setString(10, this.body.getValue());
            statement.setInt(11, Integer.parseInt(this.distance.getText()));
            statement.setString(13, "pending");
            statement.setString(14, "false");

            // Handle the image file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String fileName = file.getName().toLowerCase();
                if (fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("png")) {
                    statement.setBinaryStream(12, new FileInputStream(file));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid image format. Please select a JPG, JPEG, or PNG file.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                statement.setNull(12, java.sql.Types.BINARY);
            }


            statement.executeUpdate();


            JOptionPane.showMessageDialog(null, "Car added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (SQLException | IOException e) {

            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred while closing resources: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void clearFields() {
        this.make.setValue("");
        this.model.setText("");
        this.condition.setValue("");
        this.year.setText("");
        this.price.setText("");
        this.engine.setText("");
        this.color.setText("");
        this.fuel.setValue("");
        this.trans.setValue("");
        this.body.setValue("");
        this.distance.setText("");
    }

    private String encodeFileToBase64(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStream.read(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        make.getItems().addAll(CarsType);
        make.setEditable(true);

        condition.getItems().addAll(conditions);
        body.getItems().addAll(CarStyle);
        fuel.getItems().addAll(Fuel);
        trans.getItems().addAll(Transmission);

    }
}
