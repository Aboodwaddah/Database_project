package com.example.databaseproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import org.postgresql.Driver;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Admin  implements Initializable{
    @FXML
    private TableView<Cars> CarInfo;
    @FXML
    private TableColumn<Cars, Integer> IdColumn;
    @FXML
    private TableColumn<Cars, String> MakeColumn;
    @FXML
    private TableColumn<Cars, String> ModelColumn;
    @FXML
    private TableColumn<Cars, String> ConditionColumn;
    @FXML
    private TableColumn<Cars, Integer> YearColumn;
    @FXML
    private TableColumn<Cars, Integer> PriceColumn;
    @FXML
    private TableColumn<Cars, Integer> EngineColumn;
    @FXML
    private TableColumn<Cars, String> ColorColumn;
    @FXML
    private TableColumn<Cars, String> FuelColumn;
    @FXML
    private TableColumn<Cars, String> TransColumn;
    @FXML
    private TableColumn<Cars, String> BodystyleColumn;
    @FXML
    private TableColumn<Cars, Integer> DistanceColumn;
   @FXML
    private Pane CarTableView;
    @FXML
    private Pane addcar;
    @FXML
    private TextField color;
    @FXML
    private TextField body;

    @FXML
    private TextField IDForCar;
    @FXML
    private TextField MakeForCar;
    @FXML
    private TextField condition;
    @FXML
    private TextField distance;
    @FXML
    private TextField email;
    @FXML
    private TextField engine;
    @FXML
    private TextField fuel;
    @FXML
    private ImageView showroom;
    @FXML
    private ImageView CarTable;
    @FXML
    private ChoiceBox<String>ConditionForCar;
    @FXML
    private TextField make;
    @FXML
    private TextField model;
    @FXML
    private TextField phone;
    @FXML
    private TextField idcar;
    @FXML
    private TextField price;
    @FXML
    private TextField trans;
    @FXML
    private TextField year;
    private final String[]conditions={"New","Used","Rent"};
    @FXML
    private void insertCar() {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Car (id_car, make, model, condition, year, price, Engine_capacity, color, fuel_type, transmission, body_style, distance, fuel_aconomy_rating_city, fuel_aconomy_rating_highway) " +
                    "VALUES (" + Integer.parseInt(this.idcar.getText()) + ", '" + this.make.getText() + "', '" + this.model.getText() + "', '" + this.condition.getText() + "', "
                    + Integer.parseInt(this.year.getText()) + ", " + Integer.parseInt(this.price.getText()) + ", "
                    + Integer.parseInt(this.engine.getText()) + ", '" + this.color.getText() + "', '"
                    + this.fuel.getText() + "', '" + this.trans.getText() + "', '" + this.body.getText() + "', "
                    + Integer.parseInt(this.distance.getText()) + " )";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ShowInformationCar()
    {
        fillTableWithCars();
    }
    @FXML
    public  void PaneCarTableView()
    {
        addcar.setVisible(false);
        CarTableView.setVisible(true);

    }

    @FXML
    public void changePhoto() {
        showroom.setImage(new Image(getClass().getResource("/addCar.png").toString()));
    }
    @FXML
    public void changePhoto2() {
        showroom.setImage(new Image(getClass().getResource("/VehicleShowroom.jpg").toString()));
    }
    @FXML
    public void changePhoto3() {
        CarTable.setImage(new Image(getClass().getResource("/CarViewtable2.png").toString()));
    }
@FXML
    public void changePhoto4() {
    CarTable.setImage(new Image(getClass().getResource("/CarViewtable.jpg").toString()));
    }

    @FXML
    public void PageAddCar() throws IOException {
        CarTableView.setVisible(false);
        addcar.setVisible(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IdColumn.setCellValueFactory(cellData -> cellData.getValue().idCarProperty().asObject());
        MakeColumn.setCellValueFactory(cellData -> cellData.getValue().makeProperty());
        ModelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        ConditionColumn.setCellValueFactory(cellData -> cellData.getValue().conditionProperty());
        YearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
        PriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        EngineColumn.setCellValueFactory(cellData -> cellData.getValue().engineCapacityProperty().asObject());
        ColorColumn.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        FuelColumn.setCellValueFactory(cellData -> cellData.getValue().fuelTypeProperty());
        TransColumn.setCellValueFactory(cellData -> cellData.getValue().transmissionProperty());
        BodystyleColumn.setCellValueFactory(cellData -> cellData.getValue().bodyStyleProperty());
        DistanceColumn.setCellValueFactory(cellData -> cellData.getValue().distanceProperty().asObject());
        fillTableWithCars();
        ConditionForCar.getItems().addAll(conditions);
        CarInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue != null)
            {
                SelectShow();
            }
        });

    }


    public void setEdit()
    {
        CarInfo.setEditable(true);

        setupColumnEditing();
    }
    @FXML
    public void SelectShow()
    {
        Cars selectedCar = CarInfo.getSelectionModel().getSelectedItem();

        if (selectedCar != null)
        {
            int carId = selectedCar.idCarProperty().get();
            IDForCar.setText(String.valueOf(carId));
        }
    }



    private void setupColumnEditing() {

        MakeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MakeColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setMake(event.getNewValue());
            updateCarInDatabase(car);
        });


        ModelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ModelColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setModel(event.getNewValue());
            updateCarInDatabase(car);
        });


        ConditionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ConditionColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setCondition(event.getNewValue());
            updateCarInDatabase(car);
        });


        YearColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        YearColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setYear(event.getNewValue());
            updateCarInDatabase(car);
        });


        PriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        PriceColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setPrice(event.getNewValue());
            updateCarInDatabase(car);
        });


        EngineColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        EngineColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setEngineCapacity(event.getNewValue());
            updateCarInDatabase(car);
        });


        ColorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ColorColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setColor(event.getNewValue());
            updateCarInDatabase(car);
        });


        FuelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FuelColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setFuelType(event.getNewValue());
            updateCarInDatabase(car);
        });


        TransColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TransColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setTransmission(event.getNewValue());
            updateCarInDatabase(car);
        });


        BodystyleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        BodystyleColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setBodyStyle(event.getNewValue());
            updateCarInDatabase(car);
        });


        DistanceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        DistanceColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setDistance(event.getNewValue());
            updateCarInDatabase(car);
        });
    }

    private void fillTableWithCars()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car c order by c.id_car");

            ObservableList<Cars> cars = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Cars car = new Cars(
                        resultSet.getInt("id_car"),
                        resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getString("condition"),
                        resultSet.getInt("year"),
                        resultSet.getInt("price"),
                        resultSet.getInt("engine_capacity"),
                        resultSet.getString("color"),
                        resultSet.getString("fuel_type"),
                        resultSet.getString("transmission"),
                        resultSet.getString("body_style"),
                        resultSet.getInt("distance")
                );
                cars.add(car);
            }

            CarInfo.setItems(cars);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@FXML
    private void updateCarInDatabase(Cars car) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();

            String query = "UPDATE Car SET make = '" + car.makeProperty().get() + "', " +
                    "model = '" + car.modelProperty().get() + "', " +
                    "condition = '" + car.conditionProperty().get() + "', " +
                    "year = " + car.yearProperty().get() + ", " +
                    "price = " + car.priceProperty().get() + ", " +
                    "engine_capacity = " + car.engineCapacityProperty().get() + ", " +
                    "color = '" + car.colorProperty().get() + "', " +
                    "fuel_type = '" + car.fuelTypeProperty().get() + "', " +
                    "transmission = '" + car.transmissionProperty().get() + "', " +
                    "body_style = '" + car.bodyStyleProperty().get() + "', " +
                    "distance = " + car.distanceProperty().get() + " " +
                    "WHERE id_car = " + car.idCarProperty().get() + ";";

            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void search(ActionEvent event) throws SQLException {
        CarInfo.getItems().clear();

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();

        String searchQuery = "SELECT * FROM car WHERE id_car = " + this.IDForCar.getText();

        ResultSet resultSet = statement.executeQuery(searchQuery);

        ArrayList<Cars> carList = new ArrayList<>();

        while (resultSet.next()) {
            Cars car = new Cars(
                    resultSet.getInt("id_car"),
                    resultSet.getString("make"),
                    resultSet.getString("model"),
                    resultSet.getString("condition"),
                    resultSet.getInt("year"),
                    resultSet.getInt("price"),
                    resultSet.getInt("engine_capacity"),
                    resultSet.getString("color"),
                    resultSet.getString("fuel_type"),
                    resultSet.getString("transmission"),
                    resultSet.getString("body_style"),
                    resultSet.getInt("distance")
            );
            carList.add(car);
        }

        CarInfo.setItems(FXCollections.observableArrayList(carList));

        resultSet.close();
        statement.close();
        connection.close();
    }



}
