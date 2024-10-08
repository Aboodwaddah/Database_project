package com.example.databaseproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;


public class Admin  implements Initializable {
    @FXML
    private TextField CategoryText;
    @FXML
    private TextField AmountText;
    @FXML
    private TextField EmployeeIdText;
    @FXML
    private TextField ExhibtionIdText;
    @FXML
    private TextField DescribtionText;
    @FXML
    private TextField ExpensesIdText;
    @FXML
    private Slider PriceForCar1;
    @FXML
    private Label PriceOfCar;
    @FXML
    private TableView<Cars> CarInfo;
    @FXML
    TableView<Expenses> ExpensesTable;
    @FXML
    private TableColumn<Expenses, Integer> ExpensesColumn;
    @FXML
    private TableColumn<Expenses, Integer> EmployeeColumn;
    @FXML
    private TableColumn<Expenses, LocalDate> DateColumn;
    @FXML
    private TableColumn<Expenses, Integer> AmountColumn;
    @FXML
    private TableColumn<Expenses, String> TypeColumn;
    @FXML
    private TableColumn<Expenses, String> DescribtionColumn;
    @FXML
    private TableColumn<Expenses, Integer> ExhibColumn;
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
    private TableColumn<Cars, String> SellCarColumn;
    @FXML
    private TableColumn<Cars, Integer> DistanceColumn;
    @FXML
    private TableView<Sales> SalesTable;
    @FXML
    private TableColumn<Sales, Integer> amountColumn;
    @FXML
    private TableColumn<Sales, Integer> carColumn;
    @FXML
    private TableColumn<Sales, Integer> customerColumn;
    @FXML
    private TableColumn<Sales, String> dateColumn;
    @FXML
    private TableColumn<Sales, Integer> employeeColumn;
    @FXML
    private TableColumn<Sales, Integer> exhibColumn;
    @FXML
    private TableColumn<Sales, Integer> salesIdColumn;
    @FXML
    private TextField SalesTextFiled;
    @FXML
    private TextField EmployeeTextFiled;
    @FXML
    private TextField CustomerTextFiled;
    @FXML
    private TextField AmountTextFiled;
    @FXML
    private TextField CarTextFiled;
    @FXML
    private TextField ExhibtionTextFiled;
    @FXML
    private TextArea EmployeeTable;
    @FXML
    private Pane CarTableView;
    @FXML
    private Pane addcar;
    @FXML
    private TextField color;
    @FXML
    private ComboBox<String> body;
    @FXML
    private Pane ReviewPane;
    @FXML
    ChoiceBox<String> StyleForCar;
    @FXML
    private TextField IDForCar;
    @FXML
    private ChoiceBox<String> MakeForCar;
    @FXML
    private ComboBox<String> condition;
    @FXML
    private TextField distance;
    @FXML
    private TextField email;
    @FXML
    private TextField engine;
    @FXML
    private ComboBox<String> fuel;
    @FXML
    private ImageView showroom;
    @FXML
    private ImageView CarTable;
    @FXML
    private ChoiceBox<String> ConditionForCar;
    @FXML
    private TextField make;
    @FXML
    private TextField model;

    @FXML
    private TextField price;
    @FXML
    private ComboBox<String> trans;
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
    @FXML
    private Pane salesPane;
    @FXML
    private ImageView ExpensesPic;
    @FXML
    private Pane expensesPane;
    @FXML
    private ComboBox<String>CarType;
    @FXML
    private  ImageView salespic;
    @FXML
    private  ImageView report;
    private final String[] conditions = {"", "new", "used"};
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
            "nissan"
    };
    private final String[] CarStyle =
            {
                    "",
                    "sedan",
                    "suv",
                    "hatchback",
                    "convertible",
                    "coupe",
                    "pickup",
                    "van"
            };
    private final String[] Fuel = {
            "",
            "Petrol",
            "Diesel",
            "Electric",
            "Hybrid"
    };

    private final String[] Transmission = {
            "",
            "Manual",
            "Automatic"

    };
    @FXML
    private void insertCar() {
        if (this.CarType.getValue() == null ||
                this.model.getText().isEmpty() ||
                this.condition.getValue() == null ||
                this.year.getText().isEmpty() ||
                this.price.getText().isEmpty() ||
                this.engine.getText().isEmpty() ||
                this.color.getText().isEmpty() ||
                this.fuel.getValue() == null ||
                this.trans.getValue() == null ||
                this.body.getValue() == null ||
                this.distance.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
        int result = fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        if (result != JFileChooser.APPROVE_OPTION || file == null) {
            JOptionPane.showMessageDialog(null, "Please select a valid image file.");
            return;
        }

        String fileName = file.getName().toLowerCase();
        if (!(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png"))) {
            JOptionPane.showMessageDialog(null, "Invalid file format. Please select a JPG or PNG image.");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
            DriverManager.registerDriver(new org.postgresql.Driver());

            String sql = "INSERT INTO Car (make, model, condition, year, price, engine_capacity, color, fuel_type, transmission, body_style, distance, image, pending, sell) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                String s = "true";
                String t = "false";

                statement.setString(1, this.CarType.getValue());
                statement.setString(2, this.model.getText());
                statement.setString(3, this.condition.getValue());
                statement.setInt(4, Integer.parseInt(this.year.getText()));
                statement.setInt(5, Integer.parseInt(this.price.getText()));
                statement.setInt(6, Integer.parseInt(this.engine.getText()));
                statement.setString(7, this.color.getText());
                statement.setString(8, this.fuel.getValue());
                statement.setString(9, this.trans.getValue());
                statement.setString(10, this.body.getValue());
                statement.setInt(11, Integer.parseInt(this.distance.getText()));
                statement.setString(13, s);
                statement.setString(14, t);

                if (file != null) {
                    statement.setBinaryStream(12, new FileInputStream(file));
                } else {
                    statement.setNull(12, java.sql.Types.BINARY);
                }

                statement.executeUpdate();
                connection.commit();


                clearForm();

                JOptionPane.showMessageDialog(null, "Add car successfully.");
            }
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearForm() {

        this.model.clear();
        this.year.clear();
        this.price.clear();
        this.engine.clear();
        this.color.clear();
        this.distance.clear();


        this.CarType.setValue(null);
        this.condition.setValue(null);
        this.fuel.setValue(null);
        this.trans.setValue(null);
        this.body.setValue(null);
    }



    @FXML
    public void ShowInformationCar() {
        fillTableWithCars();
    }

    @FXML
    public void PaneCarTableView() {
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
    public void changePhoto7() {

        ExpensesPic.setImage(new Image(getClass().getResource("/expenses2.jpg").toString()));
    }

    @FXML
    public void changePhoto8() {
        ExpensesPic.setImage(new Image(getClass().getResource("/expenses1.png").toString()));
    }



    @FXML
    public void changePhoto9() {

        salespic.setImage(new Image(getClass().getResource("/sales2.png").toString()));
    }

    @FXML
    public void changePhoto10() {
        salespic.setImage(new Image(getClass().getResource("/sales1.jpg").toString()));
    }


    @FXML
    public void changePhoto11() {

        report.setImage(new Image(getClass().getResource("/d1.jpg").toString()));
    }

    @FXML
    public void changePhoto12() {

        report.setImage(new Image(getClass().getResource("/d2.png").toString()));
    }
    @FXML
    public void EnterExpensesPage() {
        expensesPane.setVisible(true);
    }

    @FXML
    public void BackExpensesPage() {
        expensesPane.setVisible(false);

    }

    @FXML
    public void goToReview() {
        ReviewPane.setVisible(true);
        CarTableView.setVisible(false);
        addcar.setVisible(false);
    }

    @FXML
    public void ReturnBackReview() {
        ReviewPane.setVisible(false);
        CarTableView.setVisible(false);
        addcar.setVisible(false);
    }

    @FXML
    public void PageAddCar() throws IOException {
        CarTableView.setVisible(false);
        addcar.setVisible(true);
    }

    @FXML
    public void ReturnFromSales() {
        salesPane.setVisible(false);
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
        PendCarColumn.setCellValueFactory(cellData -> cellData.getValue().PendingCarProperty());
        SellCarColumn.setCellValueFactory(cellData -> cellData.getValue().sellProperty());
        ExpensesColumn.setCellValueFactory(cellData -> cellData.getValue().idExpensesProperty().asObject());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().expensesDateProperty());
        AmountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        DescribtionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        TypeColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        ExhibColumn.setCellValueFactory(cellData -> cellData.getValue().idExhibitionProperty().asObject());
        EmployeeColumn.setCellValueFactory(cellData -> cellData.getValue().idEmployeeProperty().asObject());
        salesIdColumn.setCellValueFactory(cellData -> cellData.getValue().idSalesProperty().asObject());
        carColumn.setCellValueFactory(cellData -> cellData.getValue().idCarProperty().asObject());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateSalesProperty());
        exhibColumn.setCellValueFactory(cellData -> cellData.getValue().exhibitionIdProperty().asObject());
        employeeColumn.setCellValueFactory(cellData -> cellData.getValue().idEmployeeProperty().asObject());
        customerColumn.setCellValueFactory(cellData -> cellData.getValue().idCustomerProperty().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        ConditionForCar.getItems().addAll(conditions);
        MakeForCar.getItems().addAll(CarsType);
        StyleForCar.getItems().addAll(CarStyle);
        CarType.getItems().addAll(CarsType);
        condition.getItems().addAll(conditions);
        body.getItems().addAll(CarStyle);
        fuel.getItems().addAll(Fuel);
        trans.getItems().addAll(Transmission);
        try {
            InsertSales();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        fillTableWithCars();
        GetExpenses();
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


    public void setEdit() {
        CarInfo.setEditable(true);

        setupColumnEditing();
    }

    @FXML
    public void SelectShow() {
        Cars selectedCar = CarInfo.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
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

        PendCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PendCarColumn.setOnEditCommit(event -> {
            Cars car = event.getRowValue();
            car.setPending(event.getNewValue());
            updateCarInDatabase(car);
        });
    }


    private void setupColumnEditingExpenses() {

        EmployeeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        EmployeeColumn.setOnEditCommit(event -> {
            Expenses expense = event.getRowValue();
            expense.setIdEmployee(event.getNewValue());
            try {
                updateExpenseInDatabase(expense);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        DateColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        DateColumn.setOnEditCommit(event -> {
            Expenses expense = event.getRowValue();
            expense.setExpensesDate(event.getNewValue());
            try {
                updateExpenseInDatabase(expense);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        AmountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        AmountColumn.setOnEditCommit(event -> {
            Expenses expense = event.getRowValue();
            expense.setAmount(event.getNewValue());
            try {
                updateExpenseInDatabase(expense);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        TypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TypeColumn.setOnEditCommit(event -> {
            Expenses expense = event.getRowValue();
            expense.setCategory(event.getNewValue());
            try {
                updateExpenseInDatabase(expense);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        DescribtionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DescribtionColumn.setOnEditCommit(event -> {
            Expenses expense = event.getRowValue();
            expense.setDescription(event.getNewValue());
            try {
                updateExpenseInDatabase(expense);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        ExhibColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ExhibColumn.setOnEditCommit(event -> {
            Expenses expense = event.getRowValue();
            expense.setIdExhibition(event.getNewValue());
            try {
                updateExpenseInDatabase(expense);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void EditExpenses() throws SQLException {
        ExpensesTable.setEditable(true);

        setupColumnEditingExpenses();
    }

    public void updateExpenseInDatabase(Expenses expense) throws SQLException {
        String sql = "UPDATE expenses SET expenses_date = ?, amount = ?, description = ?, category = ?, id_exhibition = ?, id_employee = ? WHERE id_expenses = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, java.sql.Date.valueOf(expense.getExpensesDate()));
            preparedStatement.setInt(2, expense.getAmount());
            preparedStatement.setString(3, expense.getDescription());
            preparedStatement.setString(4, expense.getCategory());
            preparedStatement.setInt(5, expense.getIdExhibition());
            preparedStatement.setInt(6, expense.getIdEmployee());


            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void insertExpensesOperation() throws SQLException {
        String category = CategoryText.getText();
        String description = DescribtionText.getText();
        int amount = Integer.parseInt(AmountText.getText());
        int employeeId = Integer.parseInt(EmployeeIdText.getText());
        int exhibitionId = Integer.parseInt(ExhibtionIdText.getText());
        LocalDate currentDate = LocalDate.now();

        String sql = "INSERT INTO expenses (expenses_date, amount, description, category, id_exhibition, id_employee) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, java.sql.Date.valueOf(currentDate));
            preparedStatement.setInt(2, amount);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, category);
            preparedStatement.setInt(5, exhibitionId);
            preparedStatement.setInt(6, employeeId);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@FXML
    public void setupSalesTable() {

    amountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    amountColumn.setOnEditCommit(event -> {
        Sales sale = event.getRowValue();
        sale.setAmount(event.getNewValue());
        updateSalesInDatabase(sale);
    });


    carColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    carColumn.setOnEditCommit(event -> {
        Sales sale = event.getRowValue();
        sale.setIdCar(event.getNewValue());
        updateSalesInDatabase(sale);
    });


    dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    dateColumn.setOnEditCommit(event -> {
        Sales sale = event.getRowValue();
        sale.setDateSales(String.valueOf(LocalDate.parse(event.getNewValue())));
        updateSalesInDatabase(sale);
    });


    employeeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    employeeColumn.setOnEditCommit(event -> {
        Sales sale = event.getRowValue();
        sale.setIdEmployee(event.getNewValue());
        updateSalesInDatabase(sale);
    });


    customerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    customerColumn.setOnEditCommit(event -> {
        Sales sale = event.getRowValue();
        sale.setIdCustomer(event.getNewValue());
        updateSalesInDatabase(sale);
    });


    exhibColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    exhibColumn.setOnEditCommit(event -> {
        Sales sale = event.getRowValue();
        sale.setExhibitionId(event.getNewValue());
        updateSalesInDatabase(sale);
    });




    SalesTable.setEditable(true);
    }

    private void updateSalesInDatabase(Sales sale) {
        String sql = "UPDATE sales SET id_car = ?, date_sales = ?, exhibition_id = ?, id_employee = ?, id_customer = ?, amount = ? WHERE id_sales = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, sale.getIdCar());
            preparedStatement.setDate(2, java.sql.Date.valueOf(sale.getDateSales()));
            preparedStatement.setInt(3, sale.getExhibitionId());
            preparedStatement.setInt(4, sale.getIdEmployee());
            preparedStatement.setInt(5, sale.getIdCustomer());
            preparedStatement.setInt(6, sale.getAmount());
            preparedStatement.setInt(7, sale.getIdSales());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void ShowAllExpenses() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM expenses order by id_expenses;";
        ResultSet resultSet = statement.executeQuery(sql);
        ExpensesTable.getItems().clear();
        while (resultSet.next()) {
            int idExpenses = resultSet.getInt("id_expenses");
            LocalDate expensesDate = resultSet.getDate("expenses_date").toLocalDate();
            int amount = resultSet.getInt("amount");
            String description = resultSet.getString("description");
            String category = resultSet.getString("category");
            int idExhibition = resultSet.getInt("id_exhibition");
            int idEmployee = resultSet.getInt("id_employee");

            Expenses expense = new Expenses(idExpenses, expensesDate, amount, description, category, idExhibition, idEmployee);
            ExpensesTable.getItems().add(expense);
        }


        resultSet.close();
        statement.close();
        connection.close();
    }


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
        if (selectedCar != null) {
            CarInfo.getItems().remove(selectedCar);
            DeletfromDB(selectedCar);
        }


    }

    @FXML
    private void RemoveExpenses() throws SQLException {
        Expenses selectedExpenses = ExpensesTable.getSelectionModel().getSelectedItem();
        if (selectedExpenses != null) {
            ExpensesTable.getItems().remove(selectedExpenses);
            DeleteExpenses(selectedExpenses);
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
                String note = "note :" + notesResultSet.getString("note");
                Label label = new Label(note);
                label.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
                vbox.getChildren().add(label);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }






    public void returnFromAddCar() {
        addcar.setVisible(false);
        CarTableView.setVisible(false);
    }

    public void returnFromTableview() {
        addcar.setVisible(false);
        CarTableView.setVisible(false);
    }










    public void GetExpenses() {
        ObservableList<Expenses> expensesList = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses ORDER BY id_expenses");
            ObservableList<Expenses> expenses = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Expenses expenses1 = new Expenses(
                        resultSet.getInt("id_expenses"),
                        resultSet.getDate("expenses_date").toLocalDate(),
                        resultSet.getInt("amount"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getInt("id_exhibition"),
                        resultSet.getInt("id_employee")
                );
                expenses.add(expenses1);
            }
            ExpensesTable.setItems(expenses);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }










    @FXML
    public void SearchExpenses() throws SQLException {
        try {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();

            StringBuilder sql = new StringBuilder("SELECT * FROM expenses WHERE 1=1");
            String id = ExpensesIdText.getText();
            String Cat = CategoryText.getText();
            String idemplo = EmployeeIdText.getText();
            String idexp = ExhibtionIdText.getText();

            if (id != null && !id.isEmpty()) {
                sql.append(" AND id_expenses = ").append(id);
            }
            if (Cat != null && !Cat.isEmpty()) {
                sql.append(" AND category = '").append(Cat).append("'");
            }
            if (idemplo != null && !idemplo.isEmpty()) {
                sql.append(" AND id_employee = ").append(idemplo);
            }
            if (idexp != null && !idexp.isEmpty()) {
                sql.append(" AND id_exhibition = ").append(idexp);
            }


            ExpensesTable.getItems().clear();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            ObservableList<Expenses> expenses = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Expenses expense = new Expenses(
                        resultSet.getInt("id_expenses"),
                        resultSet.getDate("expenses_date").toLocalDate(),
                        resultSet.getInt("amount"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getInt("id_exhibition"),
                        resultSet.getInt("id_employee")
                );
                expenses.add(expense);
            }
            ExpensesTable.setItems(expenses);
            resultSet.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format: " + e.getMessage());
        }
    }


    public void ShowEmployeeTable() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Employee;";


        EmployeeTable.setText("id_Employee\t\tsalary\t\t position\n");

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idEmployee = resultSet.getInt("id_employee");
            int salary = resultSet.getInt("salary");
            String position = resultSet.getString("position");
            String row = idEmployee + "\t\t\t\t" + salary + "\t\t\t\t" + position + "\n";
            EmployeeTable.appendText(row);

        }

        resultSet.close();
        statement.close();
        connection.close();
    }







    @FXML
    public void DeleteExpenses(Expenses expenses) {
        int selectedId = expenses.idExpensesProperty().get();

        if (selectedId <= 0) {
            return;
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement statement = connection.createStatement()) {

            String delete = "DELETE FROM expenses WHERE id_expenses = " + selectedId + ";";
            statement.executeUpdate(delete);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void GoToSales() {
        salesPane.setVisible(true);
    }


    public void SearchSales() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from sales where 1=1");

            String idsales = SalesTextFiled.getText();
            String idEmp = EmployeeTextFiled.getText();
            String idCust = CustomerTextFiled.getText();
            String idCar = CarTextFiled.getText();

            if (idsales != null && !idsales.isEmpty()) {
                sql.append(" AND id_sales = ").append(idsales);
            }
            if (idEmp != null && !idEmp.isEmpty()) {
                sql.append(" AND id_employee = ").append(idEmp);
            }
            if (idCust != null && !idCust.isEmpty()) {
                sql.append(" AND id_customer = ").append(idCust);
            }
            if (idCar != null && !idCar.isEmpty()) {
                sql.append(" AND id_car = ").append(idCar);
            }



            SalesTable.getItems().clear();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            ObservableList<Sales> sales = FXCollections.observableArrayList();

            while (resultSet.next()) {
                Sales sale = new Sales(
                        resultSet.getInt("id_sales"),
                        resultSet.getInt("id_car"),
                        resultSet.getString("date_sales"),
                        resultSet.getInt("exhibition_id"),
                        resultSet.getInt("id_employee"),
                        resultSet.getInt("id_customer"),
                        resultSet.getInt("amount")
                );
                sales.add(sale);
            }

            SalesTable.setItems(sales);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






    public void AddSales() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

        String sql = "INSERT INTO sales (id_car, date_sales, exhibition_id, id_employee, id_customer, amount) VALUES (?, ?, ?, ?, ?, ?)";
        int idcar = Integer.parseInt(CarTextFiled.getText());
        int idCus = Integer.parseInt(CustomerTextFiled.getText());
        int amount = Integer.parseInt(AmountTextFiled.getText());
        int ex = Integer.parseInt(ExhibtionTextFiled.getText());
        int idemp = Integer.parseInt(EmployeeTextFiled.getText());
        LocalDate currentDate = LocalDate.now();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idcar);
            preparedStatement.setDate(2, java.sql.Date.valueOf(currentDate));
            preparedStatement.setInt(3, ex);
            preparedStatement.setInt(4, idemp);
            preparedStatement.setInt(5, idCus);
            preparedStatement.setInt(6, amount);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

            resetTextFields();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void resetTextFields() {
        CarTextFiled.setText("");
        CustomerTextFiled.setText("");
        AmountTextFiled.setText("");
        ExhibtionTextFiled.setText("");
        EmployeeTextFiled.setText("");
        SalesTextFiled.setText("");
    }


    @FXML
    private void RemoveSales() throws SQLException {
        Sales selectedSales = SalesTable.getSelectionModel().getSelectedItem();
        if (selectedSales != null) {
            SalesTable.getItems().remove(selectedSales);
            DeleteSales(selectedSales);
        }

    }








    @FXML
    public void DeleteSales(Sales sales) {
        int selectedId = sales.getIdSales();

        if (selectedId <= 0) {
            return;
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
             Statement statement = connection.createStatement()) {

            String delete = "DELETE FROM sales WHERE id_sales = " + selectedId + ";";
            statement.executeUpdate(delete);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }









    public void InsertSales() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        String sql = "Select * from sales order by id_sales;";
        ResultSet resultSet = statement.executeQuery(sql);
        ObservableList<Sales> sales = FXCollections.observableArrayList();
        while (resultSet.next()) {

            Sales sale = new Sales(
                    resultSet.getInt("id_sales"),
                    resultSet.getInt("id_car"),
                    resultSet.getString("date_sales"),
                    resultSet.getInt("exhibition_id"),
                    resultSet.getInt("id_employee"),
                    resultSet.getInt("id_customer"),
                    resultSet.getInt("amount")
            );
            sales.add(sale);
        }

        SalesTable.setItems(sales);
        connection.close();
    }

    public void showReportSales() {
        try {


            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            JasperDesign design= JRXmlLoader.load("src/main/resources/Report/sales.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,null,connection);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void showReportExpenses(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            JasperDesign design= JRXmlLoader.load("src/main/resources/Report/newExpenses.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,null,connection);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    public void showAll(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            JasperDesign design= JRXmlLoader.load("src/main/resources/Report/SE.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,null,connection);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void ShowSoledCar() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement= connection.createStatement();
        String sql="select * from car where sell='true'";
        ResultSet resultSet= statement.executeQuery(sql);
        CarInfo.getItems().clear();
        ObservableList<Cars> car = FXCollections.observableArrayList();
        while (resultSet.next())
        {
            Cars cars = new Cars(
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
                               resultSet.getString("sell"));
            car.add(cars);
        }
        CarInfo.setItems(car);
    }


    public void ShowUnSoledCar() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement= connection.createStatement();
        String sql="select * from car where sell='false'";
        ResultSet resultSet= statement.executeQuery(sql);
        CarInfo.getItems().clear();
        ObservableList<Cars> car = FXCollections.observableArrayList();
        while (resultSet.next())
        {
            Cars cars = new Cars(
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
                    resultSet.getString("sell"));
            car.add(cars);
        }
        CarInfo.setItems(car);
    }
    public void ShowPendingCar() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement= connection.createStatement();
        String sql="select * from car where pending='false'";
        ResultSet resultSet= statement.executeQuery(sql);
        CarInfo.getItems().clear();
        ObservableList<Cars> car = FXCollections.observableArrayList();
        while (resultSet.next())
        {
            Cars cars = new Cars(
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
                    resultSet.getString("sell"));
            car.add(cars);
        }
        CarInfo.setItems(car);
    }

}








