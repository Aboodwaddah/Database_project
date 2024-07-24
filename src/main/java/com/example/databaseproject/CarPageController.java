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

public class CarPageController implements Initializable
{
    @FXML
    private GridPane CarContainer;
    @FXML
    private HBox CarLayout;
    private List<Car>recentlyAdded;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int coul=0;
        int row=1;
        recentlyAdded=new ArrayList<>(recentlyAdded());
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
                GridPane.setMargin(cardbox,new Insets(8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private List<Car>recentlyAdded()
    {
        List<Car> ls=new ArrayList<>();
        Car car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("abood");
        car.setMake("skoda");


        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);

        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);
        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);
        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);
        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);
        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);
        car = new Car();
        car.setYear("2019");
        car.setType("sedan");
        car.setTrans("auto");
        car.setImagSrc("/main/resources/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg");
        car.setDiscribe("just used for 3 months");
        car.setMake("skoda");
        ls.add(car);


        ls.add(car);



        return ls;



    }
}
