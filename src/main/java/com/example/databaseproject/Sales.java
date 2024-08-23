package com.example.databaseproject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sales {
    private IntegerProperty idSales;
    private IntegerProperty idCar;
    private StringProperty dateSales;
    private IntegerProperty exhibitionId;
    private IntegerProperty idAdmin;
    private IntegerProperty idEmployee;
    private IntegerProperty idCustomer;
    private IntegerProperty amount;

    // Default constructor
    public Sales() {
        this.idSales = new SimpleIntegerProperty();
        this.idCar = new SimpleIntegerProperty();
        this.dateSales = new SimpleStringProperty();
        this.exhibitionId = new SimpleIntegerProperty();
        this.idAdmin = new SimpleIntegerProperty();
        this.idEmployee = new SimpleIntegerProperty();
        this.idCustomer = new SimpleIntegerProperty();
        this.amount = new SimpleIntegerProperty();
    }

    // Parameterized constructor
    public Sales(int idSales, int idCar, String dateSales, int exhibitionId, int idAdmin, int idEmployee, int idCustomer, int amount) {
        this.idSales = new SimpleIntegerProperty(idSales);
        this.idCar = new SimpleIntegerProperty(idCar);
        this.dateSales = new SimpleStringProperty(dateSales);
        this.exhibitionId = new SimpleIntegerProperty(exhibitionId);
        this.idAdmin = new SimpleIntegerProperty(idAdmin);
        this.idEmployee = new SimpleIntegerProperty(idEmployee);
        this.idCustomer = new SimpleIntegerProperty(idCustomer);
        this.amount = new SimpleIntegerProperty(amount);
    }

    // Getters and setters
    public int getIdSales() {
        return idSales.get();
    }

    public void setIdSales(int idSales) {
        this.idSales.set(idSales);
    }

    public IntegerProperty idSalesProperty() {
        return idSales;
    }

    public int getIdCar() {
        return idCar.get();
    }

    public void setIdCar(int idCar) {
        this.idCar.set(idCar);
    }

    public IntegerProperty idCarProperty() {
        return idCar;
    }

    public String getDateSales() {
        return dateSales.get();
    }

    public void setDateSales(String dateSales) {
        this.dateSales.set(dateSales);
    }

    public StringProperty dateSalesProperty() {
        return dateSales;
    }

    public int getExhibitionId() {
        return exhibitionId.get();
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId.set(exhibitionId);
    }

    public IntegerProperty exhibitionIdProperty() {
        return exhibitionId;
    }

    public int getIdAdmin() {
        return idAdmin.get();
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin.set(idAdmin);
    }

    public IntegerProperty idAdminProperty() {
        return idAdmin;
    }

    public int getIdEmployee() {
        return idEmployee.get();
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee.set(idEmployee);
    }

    public IntegerProperty idEmployeeProperty() {
        return idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer.get();
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer.set(idCustomer);
    }

    public IntegerProperty idCustomerProperty() {
        return idCustomer;
    }

    public int getAmount() {
        return amount.get();
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public IntegerProperty amountProperty() {
        return amount;
    }
}
