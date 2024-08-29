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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;
import org.postgresql.Driver;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CarPageController implements Initializable {

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
    private Label id;
    @FXML
    private Label Phone;
    @FXML
    private Label Email;
    @FXML
    private Pane Contact;
    public static int id1;
    int value;
    private byte[] image;

    @FXML
    private Button butEmp;

    @FXML
    private Pane paneEmp;

    @FXML
    private TableView<Cars> CarInfo;

    @FXML
    private TableColumn<Cars, Integer> IdColumn;
    @FXML
    private TableColumn<Cars, String> MakeColumn;
    @FXML
    private TableColumn<Cars, String> ModelColumn;
    @FXML
    private TableColumn<Cars, String> SellCarColumn;
    @FXML
    private TableColumn<Cars, String> ConditionColumn;
    @FXML
    private TableColumn<Cars, Integer> YearColumn;
    @FXML
    private TableColumn<Cars, String> PendCarColumn;
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
    private ImageView CarPhoto;
    @FXML
    private TextField IDForCar;
    @FXML
    private ChoiceBox<String> MakeForCar;
    @FXML
    ChoiceBox<String> StyleForCar;
    @FXML
    private ChoiceBox<String> ConditionForCar;
    @FXML
    private Slider PriceForCar1;
    @FXML
    private Label PriceOfCar;


    @FXML

    public void setButtonEmployee(ActionEvent event) {
        paneEmp.setVisible(true);
    }


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
        Make.getItems().addAll( "",
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
                "subaru",
                "peugeot",
                "renault",
                "jaguar",
                "land rover",
                "porsche",
                "fiat",
                "mini",
                "mitsubishi",
                "buick",
                "cadillac",
                "lincoln",
                "infiniti",
                "acura",
                "lexus",
                "mazda",
                "dodge",
                "chrysler",
                "ram",
                "gmc",
                "suzuki",
                "hummer",
                "great wall",
                "changan",
                "byd",
                "geely",
                "dongfeng",
                "nissan");
        Cond.getItems().addAll("", "new", "used");
        Trans.getItems().addAll("", "manual", "automatic");
        Year.getItems().add("");
        for (int year = 2000; year <= 2024; year++) {
            Year.getItems().add(String.valueOf(year));
        }
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
        PendCarColumn.setCellValueFactory(cellData -> cellData.getValue().PendingCarProperty());
        fillTableWithCars();
        PriceForCar1.valueProperty().addListener((observable, oldValue, newValue) -> {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
            String formattedPrice = numberFormat.format(newValue.intValue());
            PriceOfCar.setText(formattedPrice);
        });
        CarInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int idCar = newValue.idCarProperty().get();
                try {
                    Image image = getImageFromDatabase(idCar);
                    CarPhoto.setImage(image);
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            EmployeeButton();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        Contact.setVisible(false);
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
        String e = Model1.getText();
        String c = Cond.getValue();
        String y = Year.getValue();
        String u = Trans.getValue();
        double w = mySlider.getValue();
        if (d != null && !d.isEmpty()) {
            searchQuery.append(" and distance = ").append(d);
        }
        if (m != null && !m.isEmpty()) {
            searchQuery.append(" and make='").append(m).append("'");
        }
        if (e != null && !e.isEmpty()) {
            searchQuery.append(" and model='").append(e).append("'");
        }
        if (c != null && !c.isEmpty()) {
            searchQuery.append(" and condition='").append(c).append("'");
        }
        if (y != null && !y.isEmpty()) {
            searchQuery.append(" and year='").append(y).append("'");
        }
        if (u != null && !u.isEmpty()) {
            searchQuery.append(" and transmission='").append(u).append("'");
        }
        if (w > 0) {
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
                    JOptionPane.showMessageDialog(null,"Thank you for trusting us, enjoy your drive. ");
                }
                connection.commit();
                Sales();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public void setSelected() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        DriverManager.registerDriver(new org.postgresql.Driver());
        Statement statement = connection.createStatement();
        String str = "select from person where person_type='employee'";
    }

    @FXML
    private void fillTableWithCars() {
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
                        resultSet.getInt("distance"),
                        resultSet.getString("pending"),
                        resultSet.getString("sell")
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
    public void ContactUs() throws SQLException {
        Contact.setVisible(true);
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        ;
        DriverManager.registerDriver(new org.postgresql.Driver());
        String sql = "select email,phone from person where person_type='employee' ORDER BY RANDOM() LIMIT 1;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Phone.setText(resultSet.getString("phone"));
            Email.setText(resultSet.getString("email"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void Sales() throws SQLException {

        String idCar = hiddenid.getText();
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO public.sales (id_car, id_customer, date_sales, exhibition_id, id_employee, amount)\n" +
                "SELECT " + idCar + ", " + id1 + ", CURRENT_DATE, 1, \n" +
                "       (SELECT id_person FROM public.person WHERE person_type = 'employee' ORDER BY random() LIMIT 1), \n" +
                "       car.price\n" +
                "FROM public.car\n" +
                "WHERE car.id_car = " + idCar + ";";

        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    private Image getImageFromDatabase(int idCar) throws SQLException, IOException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {



            String sql = "SELECT image FROM car WHERE id_car = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idCar);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        byte[] imageBytes = resultSet.getBytes("image");
                        if (imageBytes != null) {

                            InputStream is = new ByteArrayInputStream(imageBytes);
                            return new Image(is);
                        }
                    }
                }
            }
        }

        return null;
    }


    public void EmployeeButton() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        DriverManager.registerDriver(new Driver());
        Statement statement = connection.createStatement();
        String personType = "";
        String sql = "select person_type from person where id_person =" + id1;
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            personType = resultSet.getString("person_type");
        }
        if (personType.equals("employee"))
            butEmp.setVisible(true);
        else {
            butEmp.setVisible(false);

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

        PendCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PendCarColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setPending(event.getNewValue());
            updateCarInDatabase(car);
        });
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
                    "distance = " + car.distanceProperty().get() + ", " +
                    "pending = '" + car.PendingCarProperty().get() + "' " +
                    "WHERE id_car = " + car.idCarProperty().get() + ";";


            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setEdit() {
        CarInfo.setEditable(true);

        setupColumnEditing();
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
                        resultSet.getInt("distance"),
                        resultSet.getString("pending"),
                        resultSet.getString("sell")
                );
                carList.add(car);
            }

            CarInfo.setItems(FXCollections.observableArrayList(carList));



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void Remove() throws SQLException {
        Cars selectedCar = CarInfo.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            CarInfo.getItems().remove(selectedCar);
            DeletfromDB(selectedCar);
        }
    }
    private void DeletfromDB(Cars car) throws SQLException {
        int selectedId = car.idCarProperty().get();
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres1", "postgres", "1234");
        Statement statement = connection.createStatement();
        String delete = "DELETE FROM car WHERE id_car = " + selectedId + ";";
        statement.executeUpdate(delete);
        statement.close();
        connection.close();
    }
public void Return1()
{
    paneEmp.setVisible(true);
}

}