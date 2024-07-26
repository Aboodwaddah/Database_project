package com.example.databaseproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
//s
    @FXML
    private Slider PriceSlider;
    @FXML
    private Label price;
    int value;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        value = (int) PriceSlider.getValue();
        price.setText(Integer.toString(value) + "$");
        PriceSlider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                value = (int) PriceSlider.getValue();
                price.setText(Integer.toString(value) + "$");
            }
        });
    }

}
