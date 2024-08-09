package com.example.databaseproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarPageController implements Initializable {

    public static Pane p;
    public static ImageView img;
    public static  Label Bodyst;
    public static  Label distance;
    public static  Label Conditionn;
    public static  Label engine;
    public static  Label EconomyCity;
    public static  Label EconomyHighway;
    public static  Label Fueltype;
    public static  Label modell;
    public static  Label Pricee;
    public static  Label makee;
    public static  Label yearr;

    public static  Label transs;

    @FXML
    private GridPane CarContainer;

    @FXML
    private HBox NewCar;
    @FXML
    private Slider mySlider;
    @FXML
    private Label price;
    @FXML
    private HBox Caricon;
    @FXML
    private Pane infoPane;

    private List<Car> recentlyAdded;
    @FXML
    private ImageView CarPic;
    @FXML
    private Label Bodystyle;

    @FXML
    private Label Condition;

    @FXML Label Distance;

    @FXML
    private Pane Description;

    @FXML
    private Label EconomyRateCity;

    @FXML
    private Label EconomyRateHighway;

    @FXML
    private Label FuelType;

    @FXML
    private Label Model;

    @FXML
    private Label Price;
    @FXML
    private Label make;

    @FXML
    private Label trans;

    @FXML
    private Label Engine;

    @FXML
    private Label year;

    int value;

   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = recentlyAdded();
        initiateComponent();


        int row = 1;
        int coul=0;
        for(Car car : recentlyAdded)
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("carlist.fxml"));
                VBox cardbox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(car);

                if(coul==3)
                {
                    coul=0;
                    row++;
                }
                CarContainer.add(cardbox,coul++,row);
                GridPane.setMargin(cardbox, new Insets(8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        value=(int)mySlider.getValue();
        price.setText(Integer.toString(value)+"$");
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1)
            {
                value=(int)mySlider.getValue();
                price.setText(Integer.toString(value)+"$");
            }
        });
    }

    private void initiateComponent() {
        p=new Pane();
        p=infoPane;
        img=new ImageView();
        img=CarPic;
        Conditionn=Condition;
        Pricee=Price;
        yearr=year;
        makee=make;
        transs=trans;
        modell=Model;
        Bodyst=Bodystyle;
        distance=Distance;
      engine=Engine;
      EconomyCity=EconomyRateCity;
     EconomyHighway=EconomyRateHighway;

    }
    public void Return ()
    {
        infoPane.setVisible(false);
    }


    private List<Car> recentlyAdded() {
        List<Car> ls = new ArrayList<>();

        Car car1 = new Car();
        car1.setYear("2012");
        car1.setTransmission("auto");
        car1.setImagSrc("C:/Users/PC/Documents/Database_project/DatabaseProject/src/main/resources/1720429035182-966x500.jpg");
        car1.setPrice("250000$");
        car1.setMake("skoda");
        car1.setCondition("New");
        car1.setModel("Octaiva");
        car1.setBodyStyle("sedan");
        car1.setDistance("12500km");
        car1.setEngine("2000cc");
        car1.setFuelEconomyCity("14");
        car1.setFuelEconomyHighway("20");
        ls.add(car1);

        car1 = new Car();
        car1.setYear("2012");
        car1.setTransmission("auto");
        car1.setImagSrc("C://Users//PC//Documents//Database_project//DatabaseProject//src//main//resources//car2.png");
        car1.setPrice("250000$");
        car1.setMake("skoda");
        car1.setCondition("New");
        car1.setModel("Octaiva");
        car1.setBodyStyle("sedan");
        car1.setDistance("12500km");
        car1.setEngine("2000cc");
        car1.setFuelEconomyCity("14");
        car1.setFuelEconomyHighway("20");
        ls.add(car1);


        return ls;
    }


}