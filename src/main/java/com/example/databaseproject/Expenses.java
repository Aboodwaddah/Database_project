package com.example.databaseproject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

public class Expenses {
    private final IntegerProperty idExpenses;
    private final ObjectProperty<LocalDate> expensesDate;
    private final IntegerProperty amount;
    private final StringProperty description;
    private final StringProperty category;
    private final IntegerProperty idExhibition;
    private final IntegerProperty idEmployee;

    public int getIdEmployee() {
        return idEmployee.get();
    }



    // Constructor
    public Expenses(int idExpenses,LocalDate expensesDate, int amount, String description, String category, int idExhibition, int idEmployee) {
        this.idExpenses = new SimpleIntegerProperty(idExpenses);
        this.expensesDate = new SimpleObjectProperty<>(expensesDate);
        this.amount = new SimpleIntegerProperty(amount);
        this.description = new SimpleStringProperty(description);
        this.category = new SimpleStringProperty(category);
        this.idExhibition = new SimpleIntegerProperty(idExhibition);
        this.idEmployee= new SimpleIntegerProperty(idEmployee);
    }



    public void setIdExpenses(int idExpenses) {
        this.idExpenses.set(idExpenses);
    }

    public IntegerProperty idExpensesProperty() {
        return idExpenses;
    }


    public LocalDate getExpensesDate() {
        return expensesDate.get();
    }

    public void setExpensesDate(LocalDate expensesDate) {
        this.expensesDate.set(expensesDate);
    }

    public ObjectProperty<LocalDate> expensesDateProperty() {
        return expensesDate;
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

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }


    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public int getIdExhibition() {
        return idExhibition.get();
    }

    public void setIdExhibition(int idExhibition) {
        this.idExhibition.set(idExhibition);
    }

    public IntegerProperty idExhibitionProperty() {
        return idExhibition;
    }
    public int getIdExpenses() {
        return idExpenses.get();
    }
    public IntegerProperty idEmployeeProperty() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee.set(idEmployee);
    }
}