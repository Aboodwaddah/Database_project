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
import javafx.scene.layout.VBox;

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
    @FXML
    private Slider mySlider;
   @FXML
    private Label price;
    @FXML
    private HBox Caricon;
    private List<Car> recentlyAdded;

    int value;

    private void addImageToCarIcon(String imagePath) {
        try {
            System.out.println("Loading image from path: " + imagePath);
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            Caricon.getChildren().add(imageView);
        } catch (Exception e) {
            System.err.println("Error loading image from path: " + imagePath);
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = recentlyAdded();


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


                    addImageToCarIcon("/main/resources/pngwing.png");


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




    private List<Car> recentlyAdded() {
        List<Car> ls = new ArrayList<>();

        Car car1 = new Car();
        car1.setYear("2019");
        car1.setType("sedan");
        car1.setTrans("auto");
        car1.setImagSrc("C:/Users/PC/Documents/Database_project/DatabaseProject/src/main/resources/car1.png");
        car1.setDiscribe("Just used for 3 months");
        car1.setMake("skoda");
        ls.add(car1);


        return ls;
    }


}
