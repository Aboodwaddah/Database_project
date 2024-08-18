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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import org.postgresql.Driver;
import org.w3c.dom.Text;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.Locale;
public class Admin  implements Initializable{
    @FXML
    private Slider PriceForCar1;
    @FXML
    private Label PriceOfCar;
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
    ChoiceBox<String>StyleForCar;
    @FXML
    private TextField IDForCar;
    @FXML
    private ChoiceBox<String> MakeForCar;
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

    @FXML
    private TextField r1;

    @FXML
    private TextField r2;

    @FXML
    private TextField r3;

    @FXML
    private TextField r4;

    @FXML
    private TextField r5;

    @FXML
    private TextField r6;
   @FXML
   private ImageView review;
    @FXML
    private VBox vbox;

    private final String[]conditions={"","new","used","rent"};
    private final String[] CarsType = {
            "",
            "bmw",
            "skoda",
            "toyota",
            "mercedes-benz",
            "audi",
            "honda",
            "ford",
            "volkswagen",
            "hyundai",
            "nissan",
            "chevrolet",
            "kia",
            "volvo",
            "tesla",
            "subaru"
    };
    private final String[] CarStyle =
            {
            "",
            "sedan",
            "suv",
            "hatchback",
            "convertible",
            "coupe",
            "wagon",
            "pickup",
            "van"
            };
    @FXML
    private void insertCar() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            DriverManager.registerDriver(new org.postgresql.Driver());

            String sql = "INSERT INTO Car (make, model, condition, year, price, engine_capacity, color, fuel_type, transmission, body_style, distance, image) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);


            statement.setString(1, this.make.getText());
            statement.setString(2, this.model.getText());
            statement.setString(3, this.condition.getText());
            statement.setInt(4, Integer.parseInt(this.year.getText()));
            statement.setInt(5, Integer.parseInt(this.price.getText()));
            statement.setInt(6, Integer.parseInt(this.engine.getText()));
            statement.setString(7, this.color.getText());
            statement.setString(8, this.fuel.getText());
            statement.setString(9, this.trans.getText());
            statement.setString(10, this.body.getText());
            statement.setInt(11, Integer.parseInt(this.distance.getText()));

            // Handle the image file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            if (file != null) {
                statement.setBinaryStream(12, new FileInputStream(file));
            } else {

                statement.setNull(12, java.sql.Types.BINARY);
            }


            statement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Car added successfully");
            alert.showAndWait();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        private String encodeFileToBase64(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStream.read(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    @FXML
    private  void addPhoto() throws SQLException, FileNotFoundException {


       /* if (file != null) {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            FileInputStream fis = new FileInputStream(file);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car (id_car, image) VALUES (?, ?)");
            ps.setInt(1, 1);
            ps.setBinaryStream(2, fis,(int) file.length());
            ps.executeUpdate();
            ps.close();
connection.close();
        }
    }
    */

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
    public void changePhoto5() {
        review.setImage(new Image(getClass().getResource("/customerrevie.png").toString()));
    }
    @FXML
    public void changePhoto6() {
        review.setImage(new Image(getClass().getResource("/customer.png").toString()));
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
        MakeForCar.getItems().addAll(CarsType);
        StyleForCar.getItems().addAll(CarStyle);
        CarInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue != null) {
                SelectShow();
            }

        });
        PriceForCar1.valueProperty().addListener((observable, oldValue, newValue) -> {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
            String formattedPrice = numberFormat.format(newValue.intValue());
            PriceOfCar.setText(formattedPrice);
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
    public void search(ActionEvent event) {
        CarInfo.getItems().clear();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement statement = connection.createStatement()) {

            double price = PriceForCar1.getValue();
            String selectedMake = MakeForCar.getValue();
            String idForCar = IDForCar.getText();
            String cond = ConditionForCar.getValue();
            String style = StyleForCar.getValue();

            StringBuilder searchQuery = new StringBuilder("SELECT * FROM car WHERE 1=1");

            if (idForCar != null && !idForCar.isEmpty()) {
                searchQuery.append(" AND id_car = ").append(idForCar);
            }

            if (selectedMake != null && !selectedMake.isEmpty()) {
                searchQuery.append(" AND make = '").append(selectedMake).append("'");
            }

            if (cond != null && !cond.isEmpty()) {
                searchQuery.append(" AND condition = '").append(cond).append("'");
            }

            if (price > 0) {
                searchQuery.append(" AND price BETWEEN 0 AND ").append(price);
            }

            if (style != null && !style.isEmpty()) {
                searchQuery.append(" AND body_style = '").append(style).append("'");
            }

            System.out.println("Search Query: " + searchQuery.toString());

            ResultSet resultSet = statement.executeQuery(searchQuery.toString());

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void DeletfromDB(Cars car) throws SQLException {
        int selectedId = car.idCarProperty().get();
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        String delete = "DELETE FROM car WHERE id_car = " + selectedId + ";";
        statement.executeUpdate(delete);
        statement.close();
        connection.close();
    }
@FXML
   private void Remove() throws SQLException {
        Cars selectedCar = CarInfo.getSelectionModel().getSelectedItem();
if(selectedCar !=null)
{
    CarInfo.getItems().remove(selectedCar);
    DeletfromDB(selectedCar);
}

    }


    public void setReviews() throws SQLException {


        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement statement = connection.createStatement()) {

            String query = "SELECT AVG(rate1) as avg_r1, AVG(rate2) as avg_r2, AVG(rate3) as avg_r3,AVG(rate4) as avg_r4,AVG(rate5) as avg_r5,AVG(rate6) as avg_r6 FROM reviews";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                r1.setText(String.valueOf(resultSet.getDouble("avg_r1")));
                r2.setText(String.valueOf(resultSet.getDouble("avg_r2")));
                r3.setText(String.valueOf(resultSet.getDouble("avg_r3")));
                r4.setText(String.valueOf(resultSet.getDouble("avg_r4")));
                r5.setText(String.valueOf(resultSet.getDouble("avg_r5")));
                r6.setText(String.valueOf(resultSet.getDouble("avg_r6")));

            }
            String notesQuery = "SELECT note FROM reviews";
            ResultSet notesResultSet = statement.executeQuery(notesQuery);

            vbox.getChildren().clear();

            while (notesResultSet.next()) {
                String note = "note :"+notesResultSet.getString("note");
                Label label = new Label(note);
                label.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
                vbox.getChildren().add(label);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public void returnFromAddCar()
    {
        addcar.setVisible(false);
        CarTableView.setVisible(false);
    }

    public void returnFromTableview()
    {
        addcar.setVisible(false);
        CarTableView.setVisible(false);
    }




}
