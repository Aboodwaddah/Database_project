package com.example.databaseproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.postgresql.Driver;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarPageController implements Initializable {
@FXML
public Label getuserid;
    @FXML
    private ComboBox<String> Distance1;
    @FXML
    private ComboBox<String> Cond;
    @FXML
    private ComboBox<String> Trans;
    @FXML
    private ComboBox<String> Year;
    @FXML
    private ComboBox<String> Make;
    @FXML
    private TextField Model1;
    public static Pane p;
    public static ImageView img;
    public static Label Bodyst;

    public static Label distance;
    public static Label Conditionn;
    public static Label engine;

    public static Label Fueltype;
    public static Label modell;
    public static Label Pricee;
    public static Label makee;
    public static Label yearr;

    public static Label idd;

    public static Label transs;

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

    @FXML
    Label Distance;

    @FXML
    private Pane Description;

    @FXML
    private Label hiddenid;

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
    @FXML
    private  Label id;
    public static int id1;
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
        int coul = 0;
        for (Car car : recentlyAdded) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("carlist.fxml"));
                VBox cardbox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(car);
                if (coul == 3) {
                    coul = 0;
                    row++;
                }

                CarContainer.add(cardbox, coul++, row);
                GridPane.setMargin(cardbox, new Insets(8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        value = (int) mySlider.getValue();
        price.setText(Integer.toString(value) + "$");
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                value = (int) mySlider.getValue();
                price.setText(Integer.toString(value) + "$");
            }
        });
        for (int i = 0; i <= 200000; i += 10000) {
            Distance1.getItems().add(String.valueOf(i));
        }
        Distance1.setEditable(true);
        Make.getItems().addAll("","bmw", "audi", "mercedes", "toyota", "honda", "ford", "chevrolet", "nissan", "volkswagen", "hyundai,kia,seat");
         Cond.getItems().addAll("","new","used","rent");
         Trans.getItems().addAll("","manual","automatic");
        for (int year = 2000; year <= 2024; year++) {
            Year.getItems().add(String.valueOf(year));
        }

    }


    private void initiateComponent() {
        //p = new Pane();
        p = infoPane;
        img = new ImageView();
        img = CarPic;
        Conditionn = Condition;
        Pricee = Price;
        yearr = year;
        makee = make;
        transs = trans;
        modell = Model;
        Bodyst = Bodystyle;
        distance = Distance;
        engine = Engine;
        idd = hiddenid;
          }

    public void Return() {
        infoPane.setVisible(false);
    }


    public List<Car> recentlyAdded() throws SQLException {
        List<Car> cars = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();

            String sql = "SELECT  year,id_car,transmission, image, price, make, condition, model, body_style, distance, engine_capacity " +
                    "FROM Car  Where pending ='true' and sell='false' ORDER BY id_car";


            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car();
                car.setIdCar(String.valueOf(resultSet.getInt("id_car")));
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

    public void searchCar() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        DriverManager.registerDriver(new Driver());
        Statement statement = connection.createStatement();
        StringBuilder searchQuery = new StringBuilder("SELECT * FROM car WHERE pending='true' and sell='false'");
        String d = Distance1.getValue();
        String m = Make.getValue();
        String e =Model1.getText();
        String c=Cond.getValue();
        String y= Year.getValue();
        String u=Trans.getValue();
        double w= mySlider.getValue();
        if (d != null && !d.isEmpty()) {
            searchQuery.append(" and distance = ").append(d);
        }
        if (m != null && !m.isEmpty()) {
            searchQuery.append(" and make='").append(m).append("'");
        }
        if(e!=null && !e.isEmpty())
        {
            searchQuery.append(" and model='").append(e).append("'");
        }
        if(c!=null && !c.isEmpty())
        {
            searchQuery.append(" and condition='").append(c).append("'");
        }
        if(y!=null && !y.isEmpty())
        {
            searchQuery.append(" and year='").append(y).append("'");
        }
        if(u!=null && !u.isEmpty())
        {
            searchQuery.append(" and transmission='").append(u).append("'");
        }
        if(w>0)
        {
            searchQuery.append(" and price='").append(w).append("'");
        }
        System.out.println("Executing query: " + searchQuery.toString());
        ResultSet resultSet = statement.executeQuery(searchQuery.toString());
        ArrayList<Car> carList = new ArrayList<>();
        while (resultSet.next()) {
            Car car = new Car();
            car.setImageSrc(resultSet.getBytes("image"));
            car.setMake(resultSet.getString("make"));
            car.setModel(resultSet.getString("model"));
            car.setCondition(resultSet.getString("condition"));
            car.setYear(String.valueOf(resultSet.getInt("year")));
            car.setPrice(String.valueOf(resultSet.getInt("price")));
            car.setEngine(String.valueOf(resultSet.getInt("engine_capacity")));
            car.setColor(resultSet.getString("color"));
            car.setFuelType(resultSet.getString("fuel_type"));
            car.setTransmission(resultSet.getString("transmission"));
            car.setBodyStyle(resultSet.getString("body_style"));
            car.setDistance(String.valueOf(resultSet.getInt("distance")));

            carList.add(car);
        }
        ObservableList<Car> observableCarList = FXCollections.observableArrayList(carList);


        updateCarContainer(observableCarList);

        resultSet.close();
        connection.close();
    }
    private void updateCarContainer(ObservableList<Car> observableCarList) {
        CarContainer.getChildren().clear();
        int row = 1;
        int col = 0;

        for (Car car : observableCarList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("carlist.fxml"));
                VBox cardbox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(car);

                if (col == 3) {
                    col = 0;
                    row++;
                }

                CarContainer.add(cardbox, col++, row);
                GridPane.setMargin(cardbox, new Insets(8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void SerachByBodyStyle(ActionEvent event) throws SQLException {

        Button sourceButton = (Button) event.getSource();
        String bodyStyle = sourceButton.getText();


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        DriverManager.registerDriver(new org.postgresql.Driver());
        Statement statement = connection.createStatement();


        String query = "SELECT * FROM car WHERE body_style = '" + bodyStyle + "' AND pending = 'true' AND sell = 'false'";

        ResultSet resultSet = statement.executeQuery(query);

        // Process results
        ArrayList<Car> carList = new ArrayList<>();
        while (resultSet.next()) {
            Car car = new Car();
            car.setImageSrc(resultSet.getBytes("image"));
            car.setMake(resultSet.getString("make"));
            car.setModel(resultSet.getString("model"));
            car.setCondition(resultSet.getString("condition"));
            car.setYear(String.valueOf(resultSet.getInt("year")));
            car.setPrice(String.valueOf(resultSet.getInt("price")));
            car.setEngine(String.valueOf(resultSet.getInt("engine_capacity")));
            car.setColor(resultSet.getString("color"));
            car.setFuelType(resultSet.getString("fuel_type"));
            car.setTransmission(resultSet.getString("transmission"));
            car.setBodyStyle(resultSet.getString("body_style"));
            car.setDistance(String.valueOf(resultSet.getInt("distance")));
            carList.add(car);
        }
        ObservableList<Car> observableCarList = FXCollections.observableArrayList(carList);
        updateCarContainer(observableCarList);
        resultSet.close();
        connection.close();
    }
    public void BuyOperation() throws SQLException {


        String insertSql = "INSERT INTO car_customer (id_car,id_customer) VALUES (?,?)";
        String updateSql = "UPDATE car SET sell = 'yes' WHERE id_car = ?";



        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
            DriverManager.registerDriver(new org.postgresql.Driver());


            connection.setAutoCommit(false);

            try {

                try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                    insertStatement.setInt(1, Integer.parseInt(hiddenid.getText()));
                    insertStatement.setInt(2, Integer.parseInt(String.valueOf(id1)));

                     insertStatement.executeUpdate();

                }


                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                    updateStatement.setInt(1, Integer.parseInt(hiddenid.getText()));
                    updateStatement.executeUpdate();

                }
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }


}