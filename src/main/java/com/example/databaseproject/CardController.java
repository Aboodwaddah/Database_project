package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.databaseproject.CarPageController.Conditionn;
import static com.example.databaseproject.CarPageController.EconomyCity;

public class CardController implements Initializable
{
    @FXML
    private ImageView CarPic;
    @FXML
    private AnchorPane P1;
    @FXML
    private Label Price;
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
    @FXML
    public Label Bodystyle;
    @FXML
    private  Button details;
    @FXML
    private AnchorPane APListCar;
    @FXML
    private Pane PaneListCar;
    private List<Car> recentlyAdded;
    private Pane infoPane;
    public ImageView img;
    public Label Price1;
    public  Label Condition;
    public Label yearr;
    public Label makee;
    public Label transs;
    public Label model;
    public Label BodyStylee;
    public Label Distance;
    public Label Engine;

    public Label EconomyRateCity;
    public Label EconomyRateHighway;



public Car c;
    public void setData(Car car) throws FileNotFoundException
    {
        FileInputStream input = new FileInputStream(car.getImagSrc());
        Image img = new Image(input);
        CarPic.setImage(img);
        Price.setText(car.getPrice());
        make.setText(car.getMake());
        trans.setText(car.getTransmission());
        year.setText(car.getYear());
        Bodystyle.setText(car.getBodyStyle());

        c=new Car();
        c=car;

    }




public void showInfoBtn() throws FileNotFoundException {
       infoPane.setVisible(true);
        FileInputStream input = new FileInputStream(c.getImagSrc());
        Image i = new Image(input);
       img.setImage(i);

       Price1.setText(c.getPrice());
      Condition.setText(c.getCondition());
       yearr.setText(c.getYear());
       makee.setText(c.getMake());
       transs.setText(c.getTransmission());
       model.setText(c.getModel());
       BodyStylee.setText(c.getBodyStyle());
       Distance.setText(c.getDistance());
       Engine.setText(c.getEngine());

}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        infoPane=new Pane();
        infoPane= CarPageController.p;

        img=new ImageView();
        img=CarPageController.img;
        Condition=new Label();
        Condition=CarPageController.Conditionn;
        Price1=CarPageController.Pricee;
        yearr=CarPageController.yearr;
        makee=CarPageController.makee;
        transs=CarPageController.transs;
        model=CarPageController.modell;
        BodyStylee=CarPageController.Bodyst;
        Distance=CarPageController.distance;
        Engine=CarPageController.engine;
        EconomyRateCity= CarPageController.EconomyCity;
        EconomyRateHighway=CarPageController.EconomyHighway;
    }
};


