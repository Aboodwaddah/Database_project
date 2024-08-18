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

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    private byte[] image;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            recentlyAdded = recentlyAdded();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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


    }
    public void Return ()
    {
        infoPane.setVisible(false);
    }


    public List<Car> recentlyAdded() throws SQLException {
        List<Car> cars = new ArrayList<>();
try{
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement statement = connection.createStatement();

            String sql = "SELECT year, transmission, image, price, make, condition, model, body_style, distance, engine_capacity " +
                    "FROM Car ORDER BY id_car";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Car car = new Car();
                car.setYear(String.valueOf(resultSet.getInt("year")));
                car.setTransmission(resultSet.getString("transmission"));
                car.setImageSrc(resultSet.getBytes("image"));
                car.setPrice(String.valueOf(resultSet.getInt("price")));
                car.setMake(resultSet.getString("make"));
                car.setCondition(resultSet.getString("condition"));
                car.setModel(resultSet.getString("model"));
                car.setBodyStyle(resultSet.getString("body_style"));
                car.setDistance(String.valueOf(resultSet.getInt("distance")));
                car.setEngine(String.valueOf(resultSet.getInt("engine_capacity")));

                cars.add(car);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }


}