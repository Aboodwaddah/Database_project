package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CarFuelController {

    @FXML
    private ComboBox<String> fuelTypeComboBox;

    @FXML
    public void initialize() {
        initializeBox();
    }

    private void initializeBox() {
        fuelTypeComboBox.getItems().addAll("Gasoline", "Diesel", "Electric");
        fuelTypeComboBox.setValue("Gasoline");
    }
}
