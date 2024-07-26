package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Car;

public class CardController {
    @FXML
    private ImageView CarPic;

    @FXML
    private Label describe;
    @FXML
    private AnchorPane CAP;
    @FXML
    private Label make;

    @FXML
    private Label trans;

    @FXML
    private Label type;

    @FXML
    private Label year;

    public void setData(Car car)
    {
        Image image = new Image(getClass().getResourceAsStream(car.getImagSrc()));
        CarPic.setImage(image);
        describe.setText(car.getDiscribe());
        make.setText(car.getMake());
        trans.setText(car.getTrans());
        year.setText(car.getYear());
        type.setText(car.getType());
    }
};

