package com.example.databaseproject;

import javafx.beans.property.*;

public class Cars {
    private IntegerProperty idCar;
    private StringProperty make;
    private StringProperty model;
    private StringProperty condition;
    private IntegerProperty year;
    private IntegerProperty price;
    private IntegerProperty engineCapacity;
    private StringProperty color;
    private StringProperty fuelType;
    private StringProperty transmission;
    private StringProperty bodyStyle;
    private IntegerProperty distance;

    public Cars(int idCar, String make, String model, String condition, int year, int price, int engineCapacity,
                String color, String fuelType, String transmission, String bodyStyle, int distance) {
        this.idCar = new SimpleIntegerProperty(idCar);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.condition = new SimpleStringProperty(condition);
        this.year = new SimpleIntegerProperty(year);
        this.price = new SimpleIntegerProperty(price);
        this.engineCapacity = new SimpleIntegerProperty(engineCapacity);
        this.color = new SimpleStringProperty(color);
        this.fuelType = new SimpleStringProperty(fuelType);
        this.transmission = new SimpleStringProperty(transmission);
        this.bodyStyle = new SimpleStringProperty(bodyStyle);
        this.distance = new SimpleIntegerProperty(distance);
    }

    // Property accessors
    public IntegerProperty idCarProperty() { return idCar; }
    public StringProperty makeProperty() { return make; }
    public StringProperty modelProperty() { return model; }
    public StringProperty conditionProperty() { return condition; }
    public IntegerProperty yearProperty() { return year; }
    public IntegerProperty priceProperty() { return price; }
    public IntegerProperty engineCapacityProperty() { return engineCapacity; }
    public StringProperty colorProperty() { return color; }
    public StringProperty fuelTypeProperty() { return fuelType; }
    public StringProperty transmissionProperty() { return transmission; }
    public StringProperty bodyStyleProperty() { return bodyStyle; }
    public IntegerProperty distanceProperty() { return distance; }

    // Property setters
    public void setMake(String make) { this.make.set(make); }
    public void setModel(String model) { this.model.set(model); }
    public void setCondition(String condition) { this.condition.set(condition); }
    public void setYear(int year) { this.year.set(year); }
    public void setPrice(int price) { this.price.set(price); }
    public void setEngineCapacity(int engineCapacity) { this.engineCapacity.set(engineCapacity); }
    public void setColor(String color) { this.color.set(color); }
    public void setFuelType(String fuelType) { this.fuelType.set(fuelType); }
    public void setTransmission(String transmission) { this.transmission.set(transmission); }
    public void setBodyStyle(String bodyStyle) { this.bodyStyle.set(bodyStyle); }
    public void setDistance(int distance) { this.distance.set(distance); }
}