package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void addCar() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement=connection.createStatement();
        String sql = "INSERT INTO Car (make, model, condition, year, price, engine_capacity, color, fuel_type, transmission, body_style, distance) " +
                "VALUES ('" + this.make.getText() + "', '" + this.model.getText() + "', '" + this.condition.getText() + "', "
                + Integer.parseInt(this.year.getText()) + ", " + Integer.parseInt(this.price.getText()) + ", "
                + Integer.parseInt(this.engine.getText()) + ", '" + this.color.getText() + "', '"
                + this.fuel.getText() + "', '" + this.trans.getText() + "', '" + this.body.getText() + "', "
                + Integer.parseInt(this.distance.getText()) + ")";

        statement.executeUpdate(sql);
        conn.close();
    }

}
