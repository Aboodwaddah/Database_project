package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Car;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarPageController implements Initializable {
    @FXML
    private GridPane CarContainer;

    @FXML
    private HBox NewCar;

    private List<Car> recentlyAdded;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = recentlyAdded(); // Corrected method name


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

      
    }

    private List<Car> recentlyAdded() {
        List<Car> ls = new ArrayList<>();

        Car car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);

        car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);

        car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);

       car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);

         car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);

         car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);


        return ls;
    }


}
